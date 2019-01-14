package com.altimeitrik.api2.testclient;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceForConnection {

	@Autowired
	private RestTemplate restTemplate;

	String connectionbaseURL = "http://localhost:3000/isdirectlyconnected?";
	String pathfindingURL = "http://localhost:3000/showpath?";

	public boolean calltestapi(String origin, String destination) {
	
		boolean retunrval = false;
		
	
		ResponseEntity<Boolean> resEntity = this.restTemplate.exchange(connectionbaseURL+"origin="+origin+"&destination="+destination, HttpMethod.GET, null,
				new ParameterizedTypeReference<Boolean>() {
				});
			retunrval=resEntity.getBody();
		
		return retunrval;
	}
	


}
