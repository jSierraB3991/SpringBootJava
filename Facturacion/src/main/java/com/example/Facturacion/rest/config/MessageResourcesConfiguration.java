package com.example.Facturacion.rest.config;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
@Configuration
public class MessageResourcesConfiguration {

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setDefaultEncoding("UTF-8");
    messageSource.setBasenames("classpath:/i18n/messages");
    messageSource.setUseCodeAsDefaultMessage(true);
    return messageSource;
  }

  @Bean
  public void locale() {
    Locale.setDefault(new Locale("en", "US"));
  }
}
