package com.tsystem.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsystem.models.Channels;
import com.tsystem.repo.InMemoryRepo;
import com.tsystem.service.impl.EmailServiceImpl;
import com.tsystem.service.impl.PushServiceImpl;
import com.tsystem.service.impl.SMSServiceImpl;
import com.tsystem.services.NotificationService;

@Component
public class NotificationServiceFactory {
	@Autowired
	InMemoryRepo repo;
	private  Map<String, NotificationService> instanceMap = new HashMap<String, NotificationService>();

	public  NotificationService getNotificationInstance(Channels channel) {
		NotificationService serivce = null;
		if (instanceMap.get(channel.name()) == null) {
			if (channel.name().equals("SMS")) {
				serivce = new SMSServiceImpl(repo);
				instanceMap.put(channel.name(), serivce);
			} else if (channel.name().equals("EMAIL")) {
				serivce = new EmailServiceImpl(repo);
				instanceMap.put(channel.name(), serivce);
			} else if (channel.name().equals("PUSH")) {
				serivce = new PushServiceImpl(repo);
				instanceMap.put(channel.name(), serivce);
			}
		} else {
			serivce = instanceMap.get(channel.name());
			
		}
		return serivce;

	}

}
