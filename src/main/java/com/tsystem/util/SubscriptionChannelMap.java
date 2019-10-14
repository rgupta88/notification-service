package com.tsystem.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tsystem.models.Channels;
import com.tsystem.models.Subscription;

@Component
public class SubscriptionChannelMap {

	private static Map<Subscription, List<Channels>> map = new HashMap<Subscription, List<Channels>>();
	static {
		List<Channels> silverChannelList = new ArrayList<Channels>();
		silverChannelList.add(Channels.EMAIL);
		List<Channels> goldChannelList = new ArrayList<Channels>();
		goldChannelList.add(Channels.EMAIL);
		goldChannelList.add(Channels.SMS);
		List<Channels> platinumChannelList = new ArrayList<Channels>();
		platinumChannelList.add(Channels.EMAIL);
		platinumChannelList.add(Channels.SMS);
		platinumChannelList.add(Channels.PUSH);
		map.put(Subscription.SILVER, silverChannelList);
		map.put(Subscription.GOLD, goldChannelList);
		map.put(Subscription.PLATINUM, platinumChannelList);
	}
	
	public Map<Subscription, List<Channels>> getMap(){
		System.out.println(map);
		return map;
	}
}
