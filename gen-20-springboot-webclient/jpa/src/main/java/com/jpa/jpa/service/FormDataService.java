package com.jpa.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FormDataService {
    private final WebClient webClient;

    public FormDataService(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("https://api.rajaongkir.com/starter").build();
    }

    public Mono<String> postData(String origin, String destination, int weight, String courier){
        HttpHeaders headers = new HttpHeaders();
        headers.add("key", "14ecfa8bfba82059e6af3f0d01a9acbb");

        return webClient.post()
                .uri("/cost")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("origin", origin)
                        .with("destination", destination)
                        .with("weight", String.valueOf(weight))
                        .with("courier", courier))
                .retrieve()
                .bodyToMono(String.class);
    }

}
