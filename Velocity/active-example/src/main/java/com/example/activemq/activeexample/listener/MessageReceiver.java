package com.example.activemq.activeexample.listener;

import java.util.logging.Logger;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.activemq.activeexample.model.Product;

@Component
public class MessageReceiver 
{
	private static final String QUEUE = "message_queue";
	private static final Logger LOG = Logger.getLogger(MessageReceiver.class.getName());
	
	@JmsListener(destination = QUEUE)
	public void receiverMessage(Product product) 
	{
		LOG.info("Received" + product);
	}
}