package br.com.henrique.greeting_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.henrique.greeting_service.config.GreetingConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(GreetingConfiguration.class)
public class GreetingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingServiceApplication.class, args);
	}

}
