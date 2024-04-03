package com.jpa.jpa.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.jpa.dto.ProvinceResponse;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceClient {
    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public ProvinceClient(WebClient.Builder webClientBuilder, ObjectMapper objectMapper){
        this.webClient = webClientBuilder
                .baseUrl("https://api.rajaongkir.com/starter")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.objectMapper = objectMapper;
    }

    public Mono<ProvinceResponse> fetchDataWithHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("key", "14ecfa8bfba82059e6af3f0d01a9acbb");

        return webClient
                .get()
                .uri("/province")
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .retrieve()
                .bodyToMono(String.class)
                .map(responseBody -> {
                    try{
                        return objectMapper.readValue(responseBody, ProvinceResponse.class);
                    } catch (Exception e){
                        throw new RuntimeException("Failed to map respone to ProvinceDTO" + e.getMessage());
                    }
                });
    }
}
