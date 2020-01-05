package com.example.messagingrabbitmq;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	private final RabbitTemplate rabbitTemplate;
	private final Receiver receiver;

	public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
		this.receiver = receiver;
		this.rabbitTemplate = rabbitTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		
		  System.out.println("Sending message...");
		  
		  for (int i = 0; i <= 23; i++) {
		  rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ " + i +"! ");
	    }
		  
		  System.out.println("Messages sent...");
		 

			try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
			}
			 
		  
		/* receiver.getLatch().await(10000, TimeUnit.MILLISECONDS); */
	}

}
