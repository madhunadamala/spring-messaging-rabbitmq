package com.example.messagingrabbitmq;

import java.sql.Timestamp;
import java.time.Instant;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	public void receiveMessage(String message) {
		Instant instant = Instant.now();	
		System.out.println("Received <" + message + instant + ">");
		/**/
		//latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
