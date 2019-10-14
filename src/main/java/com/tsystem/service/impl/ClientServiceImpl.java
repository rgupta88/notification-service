package com.tsystem.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsystem.models.Client;
import com.tsystem.repo.InMemoryRepo;
import com.tsystem.services.ClientService;

@Component
public class ClientServiceImpl implements ClientService {

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	@Autowired
	InMemoryRepo repo;

	@Override
	public void createORupdateClientSubscription(Client client) {
		Client existingClient = repo.getClientMap().get(client.getClientId());
		if (existingClient != null) {
			existingClient.setSubscriptionType(client.getSubscriptionType());
			setClient(existingClient);
		} else {
			setClient(client);
			repo.getClientMap().putIfAbsent(client.getClientId(), client);
		}

	}

	private void setClient(Client client) {
		Date currentDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		c.add(Calendar.MONTH, 1);
		Date dateAfterOneMonth = c.getTime();
		String startDate = dateFormat.format(currentDate);
		String endDate = dateFormat.format(dateAfterOneMonth);
		client.setSubscriptionStartDate(startDate);
		client.setSubscriptionEndDate(endDate);
	}

}
