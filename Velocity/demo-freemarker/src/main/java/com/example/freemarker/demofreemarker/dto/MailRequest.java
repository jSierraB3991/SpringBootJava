package com.example.freemarker.demofreemarker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest 
{
	private String name;
	private String to;
	private String from;
	private String subject;
}
