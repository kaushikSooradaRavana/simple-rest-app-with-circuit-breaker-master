package com.cinteo.oneweb.mbusa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@SpringBootApplication
public class SimpleRestWithCircuitBreakerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SimpleRestWithCircuitBreakerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
