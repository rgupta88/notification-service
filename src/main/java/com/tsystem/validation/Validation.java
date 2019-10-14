package com.tsystem.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsystem.dto.NotificationResponseDto;
import com.tsystem.models.Channels;
import com.tsystem.models.Client;
import com.tsystem.models.Notification;
import com.tsystem.models.SubscriptionTypeLimitPerDay;
import com.tsystem.repo.InMemoryRepo;
import com.tsystem.util.SubscriptionChannelMap;

@Component
public class Validation {

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	@Autowired
	private InMemoryRepo repo;
	@Autowired
	private SubscriptionChannelMap subsChannelMap;

	public NotificationResponseDto validateSubscriptionAndLimit(Notification notification) {
		Map<String, Client> clientMaps = repo.getClientMap();
		NotificationResponseDto response = new NotificationResponseDto();
		response.setValidSubscription(true);
		if (clientMaps == null || clientMaps.isEmpty() || clientMaps.get(notification.getClientId()) == null) {
			response.setValidSubscription(false);
			response.setStatus(NotificationResponseDto.Status.FAILED);
			response.setMsg("Add client into the system");
			return response;
		}
		validateSubscription(clientMaps.get(notification.getClientId()), notification, response);
		if(response.getValidSubscription()){
			validateLimit(clientMaps.get(notification.getClientId()), notification, response);
		}
		return response;
	}

	private void validateLimit(Client client, Notification notification, NotificationResponseDto response) {
		Map<String, Map<String, SubscriptionTypeLimitPerDay>> notificationMap = repo.getNotificationMap();
		// per client per day subscription map
		Map<String, SubscriptionTypeLimitPerDay> notificationLimitPerDayMap = notificationMap.get(client.getClientId());
		if (notificationLimitPerDayMap != null) {
			checkPerDayLimitPerClientAllChannel(notificationLimitPerDayMap, client, notification, response);
		}
	}

	private void checkPerDayLimitPerClientAllChannel(
			Map<String, SubscriptionTypeLimitPerDay> notificationLimitPerDayMap, Client client,
			Notification notification, NotificationResponseDto response) {
		Date currentDate = new Date();
		String today = dateFormat.format(currentDate);
		// Per day per channel limit object
		SubscriptionTypeLimitPerDay subscriptionlimitPerDay = notificationLimitPerDayMap.get(today);
		// Per channel recipient count map
		Map<Channels, Integer> limitPerChannelType = subscriptionlimitPerDay.getLimitPerChannelType();
		Integer notificationCountPerDayAllChannels = 0;
		for (Map.Entry<Channels, Integer> entry : limitPerChannelType.entrySet()) {
			notificationCountPerDayAllChannels += entry.getValue();
		}
		notificationCountPerDayAllChannels = notificationCountPerDayAllChannels
				+ notification.getRecipientList().size();
		Integer maximumNotificationCount = client.getSubscriptionType().getLimit();
		if (notificationCountPerDayAllChannels < maximumNotificationCount) {
			response.setValidSubscription(true);
		} else {
			response.setMsg("Today's notification limit is over");
			response.setValidSubscription(false);
			response.setStatus(NotificationResponseDto.Status.FAILED);
		}
	}

	private void validateSubscription(Client client, Notification notification, NotificationResponseDto response) {
		List<Channels> channelList = subsChannelMap.getMap().get(client.getSubscriptionType());
		if (!channelList.contains(notification.getNotificationChannel())) {
			response.setValidSubscription(false);
			response.setStatus(NotificationResponseDto.Status.FAILED);
			response.setMsg("Client " + client.getClientId() + " does not have subscription for channel "
					+ notification.getNotificationChannel().name());
			return ;
		}
		Date endDate = null;
		Date currentDate = new Date();
		try {
			endDate = dateFormat.parse(client.getSubscriptionEndDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (endDate.compareTo(currentDate) <= 0) {
			response.setValidSubscription(false);
			response.setStatus(NotificationResponseDto.Status.FAILED);
			response.setMsg("Client " + client.getClientId() + " subscription " + client.getSubscriptionType().name()
					+ " is expired. Channel :" + notification.getNotificationChannel().name());
		}
	}

}
