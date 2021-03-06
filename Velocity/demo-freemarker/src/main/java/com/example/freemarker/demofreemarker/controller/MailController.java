package com.example.freemarker.demofreemarker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.freemarker.demofreemarker.dto.MailRequest;
import com.example.freemarker.demofreemarker.dto.MailResponse;
import com.example.freemarker.demofreemarker.service.MailService;

@RestController
@RequestMapping("/message")
public class MailController 
{
	@Autowired
	private MailService mailService;
	
	@PostMapping("/sendMail")
	public MailResponse sendEmail(@RequestBody MailRequest request) 
	{
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Cartagena, Colombia");
		return mailService.sendMail(request, model);
	}
}
