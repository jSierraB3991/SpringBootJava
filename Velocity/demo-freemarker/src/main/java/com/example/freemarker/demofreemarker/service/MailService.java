package com.example.freemarker.demofreemarker.service;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.example.freemarker.demofreemarker.dto.MailRequest;
import com.example.freemarker.demofreemarker.dto.MailResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class MailService 
{

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private Configuration config;
	
	public MailResponse sendMail(MailRequest request, Map<String, Object> model) 
	{
		MailResponse response = new MailResponse();
		MimeMessage message = mailSender.createMimeMessage();

		try 
		{
			MimeMessageHelper messageHelper =new MimeMessageHelper(message, 
													MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
													StandardCharsets.UTF_8.name());
			messageHelper.addAttachment("logo.png", new ClassPathResource("logo.png"));
			
			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			messageHelper.setTo(request.getTo());
			messageHelper.setText(html, true);
			messageHelper.setSubject(request.getSubject());
			messageHelper.setFrom(request.getFrom());
			mailSender.send(message);
			

			response.setMessage("Mail Send To: " + request.getTo());
			response.setStatus(Boolean.TRUE);
		} 
		catch (Exception e) {
			response.setMessage("Mail Sending Failure: " + e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		
		return response;
	}
}
