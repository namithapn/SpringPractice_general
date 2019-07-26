package com.nami.rest.webservices.restfulwebservices;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


//password: 01e7bbaa-3e09-4a08-aae9-d0458f89afd8


@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver(){
		//SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		//change this to below to accpet header or else it will give result for default locale US
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	/**
	 * the below code can be removed if we mention "spring.messages.basename=messages"
	 * in application.properties in folder src/main/resources 
	@Bean
	public ResourceBundleMessageSource messageSource(){
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}*/
	
}
