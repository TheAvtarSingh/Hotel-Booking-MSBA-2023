package com.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate; 

@SpringBootApplication 
// Current Version Don't Need @EnableEurekaClient
public class BookingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingserviceApplication.class, args);
	}
	
	/*
	 * @Bean public WebClient.Builder getWebClientBuilder() { return
	 * WebClient.builder(); }
	 */
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
