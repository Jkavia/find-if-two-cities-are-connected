package com.altimeitrik.api2.testclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	
	@Autowired
	private ClientServiceForConnection clientServiceForConnection;
	
	@RequestMapping(value="/connected", method=RequestMethod.GET)
	public boolean findChainedConnection(@RequestParam(name="origin", required=true)String origin,@RequestParam(name="destination", required=true)String destination){
		return clientServiceForConnection.calltestapi(origin, destination);
	}
	

	
	
}
