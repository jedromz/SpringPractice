package com.jedromz.springbootconsumingrestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootConsumingRestApiApplication {

    //sends output to the log
    private static final Logger log = LoggerFactory.getLogger(SpringbootConsumingRestApiApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConsumingRestApiApplication.class, args);
    }

    //processes incoming data with Jackson JSON processing library
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    //Runs resttemplate on startup
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "https://quoters.apps.pcfone.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }

}
