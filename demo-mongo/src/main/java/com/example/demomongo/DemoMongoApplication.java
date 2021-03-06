package com.example.demomongo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DemoMongoApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder().sources(DemoMongoApplication.class).run(args);
	}

}
