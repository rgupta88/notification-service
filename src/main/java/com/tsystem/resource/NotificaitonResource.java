package com.tsystem.resource;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystem.dto.NotificationDto;
import com.tsystem.dto.NotificationResponseDto;
import com.tsystem.models.Notification;
import com.tsystem.services.NotificationService;
import com.tsystem.util.NotificationServiceFactory;
import com.tsystem.validation.Validation;

@RestController
public class NotificaitonResource {

	@Autowired
	Validation validation;
	@Autowired
	NotificationServiceFactory factory;

	@RequestMapping(path = "/send", method = RequestMethod.POST)
	public NotificationResponseDto sendNotification(@RequestBody NotificationDto dto) {
		Notification notification = convertDtoToModel(dto);
		NotificationResponseDto response = validation.validateSubscriptionAndLimit(notification);
		if (response.getValidSubscription()) {
			NotificationService service = factory
					.getNotificationInstance(dto.getNotificationChannel());
			service.notify(notification);
			response.setStatus(NotificationResponseDto.Status.SUCCESS);
			response.setMsg("Notification send successfully.");
		}
		return response;
	}

	private Notification convertDtoToModel(NotificationDto dto) {
		Notification notification = new Notification();
		notification.setClientId(dto.getClientId());
		notification.setMessage(dto.getMessage());
		notification.setNotificationId(UUID.randomUUID().toString());
		notification.setNotificationChannel(dto.getNotificationChannel());
		notification.setRecipientList(dto.getRecipientList());
		return notification;
	}

}
