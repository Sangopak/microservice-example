package com.sango.microservice.microservice.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.server.i18n.LocaleContextResolver;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ControllerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
	
	@Bean
	public LocaleContextResolver localeContextResolver() {
		AcceptHeaderLocaleContextResolver acceptHeaderLocaleContextResolver = new AcceptHeaderLocaleContextResolver();
		acceptHeaderLocaleContextResolver.setDefaultLocale(Locale.US);
		return acceptHeaderLocaleContextResolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(30);
		return messageSource;
	}
}
