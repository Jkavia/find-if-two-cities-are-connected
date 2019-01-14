package com.altimeitrik.api1.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

@Service
public class FirstApiService {

	static Map<String, Map<String, String>> connectionMap = new LinkedHashMap<String, Map<String, String>>();

	public void saveData(List<OriginDestClass> odclist) {
		// System.out.println(cityjson);

		for (OriginDestClass odc : odclist) {
			String a = odc.getStart();
			String b = odc.getDestination();
			if (connectionMap.containsKey(a)) {
				Map<String, String> innermapcontains = connectionMap.get(a);
				innermapcontains.put(b, a + b);
				connectionMap.put(a, innermapcontains);
				//
				if(connectionMap.containsKey(b)) {
					Map<String, String> innermapreverse = connectionMap.get(b);
					innermapreverse.put(a, b + a);
					connectionMap.put(b, innermapreverse);
				}
				if(!connectionMap.containsKey(b)) {
					Map<String, String> innermapreverse = new HashMap<String, String>();
					innermapreverse.put(a, b + a);
					connectionMap.put(b, innermapreverse);
				}
				
			} else {
				Map<String, String> innermap = new HashMap<String, String>();
				innermap.put(b, a + b);
				connectionMap.put(a, innermap);
				Map<String, String> innermapreverse = new HashMap<String, String>();
				innermapreverse.put(a, b + a);
				connectionMap.put(b, innermapreverse);

			}

		}
		
		recursivecall(-1,odclist);
		
	

	}
	
	//establishing all the connections
	public static void recursivecall(int index, List<OriginDestClass> list) {
		
		
		if(index==list.size()-1) {return;}
		index++;
		String origin = list.get(index).getStart();
		String destination = list.get(index).getDestination();
				
		
		
		for(String key:connectionMap.keySet()) {
			
			if(connectionMap.get(key).containsKey(origin) && key!=destination) {
				Map<String,String> innermap = connectionMap.get(key);
				innermap.put(destination, key+origin+destination);
				connectionMap.put(key, innermap);
			}
			if(connectionMap.get(key).containsKey(destination) && key!=origin) {
				Map<String,String> innermap = connectionMap.get(key);
				innermap.put(origin, key+destination+origin);
				connectionMap.put(key, innermap);
			}
		
		
	}
		
		recursivecall(index,list);	
		//System.out.println(index);
	for(String key:connectionMap.keySet()) {
			
			if(connectionMap.get(key).containsKey(origin) && key!=destination) {
				Map<String,String> innermap = connectionMap.get(key);
				innermap.put(destination, key+origin+destination);
				connectionMap.put(key, innermap);
			}
			if(connectionMap.get(key).containsKey(destination) && key!=origin) {
				Map<String,String> innermap = connectionMap.get(key);
				innermap.put(origin, key+destination+origin);
				connectionMap.put(key, innermap);
			}
		
		
	}
	
	
	}

	public boolean isThereConnection(String origin, String destination) {
		boolean returnval = false;

		if (connectionMap.containsKey(origin)) {
			Map<String, String> innermap = connectionMap.get(origin);
			if (innermap.containsKey(destination)) {
				returnval = true;
			}
		}
		return returnval;

	}

	



}
