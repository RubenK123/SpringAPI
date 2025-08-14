package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Bean
    public RestClient knmiRestClient() {
        return RestClient.builder()
                .baseUrl("https://api.dataplatform.knmi.nl")
                .defaultHeader("Authorization","Bearer eyJvcmciOiI1ZTU1NGUxOTI3NGE5NjAwMDEyYTNlYjEiLCJpZCI6IjM5NzcwODZlMTMwNjQ0ODc4NTIzMTg3MjlmNjE5ZjRjIiwiaCI6Im11cm11cjEyOCJ9")
                .build();
    }
}
