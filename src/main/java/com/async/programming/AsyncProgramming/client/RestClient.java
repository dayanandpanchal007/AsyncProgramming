package com.async.programming.AsyncProgramming.client;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestClient {

    private static final String JSON_PLACEHOLDER_POST = "https://jsonplaceholder.typicode.com/posts";

    static RestTemplate restTemplate = new RestTemplate();

    private static ResponseEntity<String> getPostApi() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(JSON_PLACEHOLDER_POST, HttpMethod.GET, entity, String.class);
        return response;
    }
}
