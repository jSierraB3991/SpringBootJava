package com.example.demomongo.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.github.cloudyrock.mongock.SpringBootMongock;
import com.github.cloudyrock.mongock.SpringBootMongockBuilder;

@Configuration
public class MongockConfig 
{
	private static final String CHANGELOG_PATH = "com.example.demomongo.data.changelogs";

    @Bean
    public SpringBootMongock mongock(MongoTemplate mongoTemplate,
            ApplicationContext springContext) {

        return new SpringBootMongockBuilder(mongoTemplate, CHANGELOG_PATH)
                .setApplicationContext(springContext)
                .setLockQuickConfig()
                .build();
    }

}
