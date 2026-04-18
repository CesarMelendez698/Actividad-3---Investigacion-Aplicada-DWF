package com.ejemplo.adf.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AdfClientConfig {

    @Value("${adf.base-url}")
    private String adfBaseUrl;

    @Bean
    public WebClient adfWebClient() {
        return WebClient.builder()
                .baseUrl(adfBaseUrl)
                .build();
    }
}

