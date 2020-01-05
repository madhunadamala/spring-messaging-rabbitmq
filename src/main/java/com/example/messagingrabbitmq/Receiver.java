package com.example.messagingrabbitmq;

import java.sql.Timestamp;
import java.time.Instant;

import java.util.concurrent.CountDownLatch;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);
	
	@Autowired
	private Queue queue;

	public void receiveMessage(String message) {
	
		
		System.out.println("Received <" + message + System.currentTimeMillis() + " Thread ID:" + Thread.currentThread().getId() +">");
		/**/
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
