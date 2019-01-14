package com.altimeitrik.api1.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@Autowired
	private FirstApiService firstApiService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveAllCities(@RequestBody List<OriginDestClass> payload) throws Exception {
		firstApiService.saveData(payload);
		return "saved data!";
	}
	
	@RequestMapping(value="/isdirectlyconnected", method=RequestMethod.GET)
	public boolean checkDirectConnection(@RequestParam(name="origin", required=true)String origin,@RequestParam(name="destination", required=true)String destination) throws Exception {
		return firstApiService.isThereConnection(origin, destination);
	}
	
}
