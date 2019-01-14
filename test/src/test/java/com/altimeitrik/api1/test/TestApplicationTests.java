package com.altimeitrik.api1.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

	
	@Autowired
	private FirstApiService firstApiService;
	
	List<OriginDestClass> odclist = new ArrayList<>();
	
	
	
	@Before
	public void loadDAta() {
		odclist.add(new OriginDestClass("A", "B"));
		odclist.add(new OriginDestClass("C", "D"));
		odclist.add(new OriginDestClass("D", "A"));
		odclist.add(new OriginDestClass("E", "F"));
		firstApiService.saveData(odclist);
	}
	
	
	@Test
	public void contextLoads() {
		
		assertEquals(true, firstApiService.isThereConnection("A", "B"));
		assertEquals(true, firstApiService.isThereConnection("B", "A"));
		assertEquals(true, firstApiService.isThereConnection("C", "D"));
		assertEquals(true, firstApiService.isThereConnection("D", "C"));
		assertEquals(true, firstApiService.isThereConnection("D", "A"));
		assertEquals(true, firstApiService.isThereConnection("A", "D"));
		assertEquals(true, firstApiService.isThereConnection("E", "F"));
		assertEquals(true, firstApiService.isThereConnection("F", "E"));
		assertEquals(false, firstApiService.isThereConnection("E", "B"));
		assertEquals(false, firstApiService.isThereConnection("C", "H"));
		assertEquals(false, firstApiService.isThereConnection("H", "H"));
	}

}

