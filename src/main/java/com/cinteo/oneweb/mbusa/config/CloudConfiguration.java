package com.cinteo.oneweb.mbusa.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@Configuration
@EnableCircuitBreaker
@EnableDiscoveryClient
@Profile(value = "cloud")
public class CloudConfiguration {

}
