package com.altimeitrik.api2.testclient;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClientApplicationTests {

	
	@Autowired
	private ClientServiceForConnection clientServiceForConnection;
	
	
	
	@Test
	public void loopOne() {
		
		assertEquals(true, clientServiceForConnection.calltestapi("a","b"));
		assertEquals(true, clientServiceForConnection.calltestapi("b","a"));
		assertEquals(true, clientServiceForConnection.calltestapi("a","d"));
		assertEquals(true, clientServiceForConnection.calltestapi("d","a"));
		assertEquals(true, clientServiceForConnection.calltestapi("a","f"));
		assertEquals(true, clientServiceForConnection.calltestapi("f","c"));
		assertEquals(false, clientServiceForConnection.calltestapi("a","j"));
	}
	@Test
	public void nonLoopPath() {
		
		assertEquals(true, clientServiceForConnection.calltestapi("h","j"));
		assertEquals(true, clientServiceForConnection.calltestapi("h","k"));
		assertEquals(false, clientServiceForConnection.calltestapi("z","u"));
		assertEquals(true, clientServiceForConnection.calltestapi("j","p"));
		assertEquals(true, clientServiceForConnection.calltestapi("m","h"));
	}

}

