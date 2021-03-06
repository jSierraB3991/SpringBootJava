package com.example.activemq.activeexample;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import com.example.activemq.activeexample.model.Product;

@SpringBootApplication
@EnableJms
public class ActiveExampleApplication {

	private static final String QUEUE = "message_queue";
	private static final Logger LOG = Logger.getLogger(ActiveExampleApplication.class.getName());
	
	public static void main(String[] args) 
	{
		ConfigurableApplicationContext context =  SpringApplication.run(
				ActiveExampleApplication.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		for (int i = 1; i <= 10; i++) 
		{
			LOG.info("Sending Product: " + i);
			jmsTemplate.convertAndSend(QUEUE, new Product(i, "Laptop #" + i, 10 + i));
		}
	}
}
