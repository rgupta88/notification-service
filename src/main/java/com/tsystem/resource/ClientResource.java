package com.tsystem.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsystem.dto.CreateClientDto;
import com.tsystem.models.Client;
import com.tsystem.services.ClientService;

@RestController
@RequestMapping("/client")
public class ClientResource {

	@Autowired
	ClientService service;

	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public String createClient(@RequestBody CreateClientDto dto) {
		service.createORupdateClientSubscription(convertDtoToModel(dto));
		return "Success";
	}
	
	private Client convertDtoToModel(CreateClientDto dto){
		Client client = new Client();
		client.setClientId(dto.getClientId());
		client.setSubscriptionType(dto.getSubscriptionType());
		return client;
	}

}
