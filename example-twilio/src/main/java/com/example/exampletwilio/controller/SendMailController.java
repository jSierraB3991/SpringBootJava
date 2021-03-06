package com.example.exampletwilio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exampletwilio.model.Mail;
import com.example.exampletwilio.model.ReturnOk;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@RestController
@RequestMapping("/sendMail")
public class SendMailController
{
	@Value("${TWILIO_SSID}")
	private String TWILIOSSID;
	
	@Value("${TWILIO_TOKEN}")
	private String TWILIOTOKEN;
	
	@Value("${TWILIO_PHONENUMBER}")
	private String TWILIOPHONENUMBERTO;
	
	@PostMapping
	public ReturnOk sendMailByTwilio(@RequestBody Mail mail) 
	{
		if(!Optional.ofNullable(mail.getMensaje()).isPresent())
			throw new RuntimeException("FATAL ERROR MESSAGE");
		if(!Optional.ofNullable(mail.getPhneNumber()).isPresent())
			throw new RuntimeException("FATAL ERROR PHONE NUMBER");
		
	    Twilio.init(TWILIOSSID, TWILIOTOKEN);
		Message message = Message.creator(new PhoneNumber(mail.getPhneNumber()),
				new PhoneNumber(TWILIOPHONENUMBERTO), mail.getMensaje()).create();
		return new ReturnOk(message.getSid());
	}
}
