package com.cinteo.oneweb.mbusa;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author Gregor Zurowski
 *
 */
@RestController
public class SimpleRestController {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleRestController.class);

    private static final String OTHER_MICROSERVICE = "simple-rest-app-with-config-v1";

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("unused")
    private ResponseEntity<String> fallback(final String name) {
        return ResponseEntity.ok("FALLBACK");
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/proxy/hello/{name}")
    public ResponseEntity<String> proxy(@PathVariable final String name) {
        if (new Random().nextInt(100) % 2 == 0) {
            throw new RuntimeException("Problem occured");
        }

        LOG.info("Proxying request with name='{}'", name);

        // @formatter:off
        return restTemplate.getForEntity(
                String.format("//%s/simple-rest-app-with-config/v1/hello/%s", OTHER_MICROSERVICE, name),
                String.class);
        // @formatter:on
    }

}
