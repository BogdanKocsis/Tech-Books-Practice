package com.practicesets.calling_rest_endpoints_using_webclient.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ProjectConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
