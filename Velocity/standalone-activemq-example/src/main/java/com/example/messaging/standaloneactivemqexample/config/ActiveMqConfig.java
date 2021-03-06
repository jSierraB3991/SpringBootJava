package com.example.messaging.standaloneactivemqexample.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqConfig {

	@Value("${ACTIVEMQ-BROKENURL}")
	private String brokenUrl;
	
	@Bean	
	public Queue queue() 
	{
		return new ActiveMQQueue("standalone.queue");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() 
	{
		return new ActiveMQConnectionFactory(brokenUrl);
	}
	
	@Bean
	public JmsTemplate jmsTemplate() 
	{
		return new JmsTemplate(activeMQConnectionFactory());
	}
}
