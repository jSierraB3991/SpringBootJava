package com.example.messaging.standaloneactivemqexample.listener;

import java.util.logging.Logger;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	private static final Logger LOG = Logger.getLogger(Consumer.class.getName());

	@JmsListener(destination = "standalone.queue")
	public void consume(String message) 
	{
		LOG.info("Recived Message: " + message);
	}
	
}
