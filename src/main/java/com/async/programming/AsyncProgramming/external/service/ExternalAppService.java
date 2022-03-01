package com.async.programming.AsyncProgramming.external.service;

import com.async.programming.AsyncProgramming.external.model.Album;
import com.async.programming.AsyncProgramming.external.model.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ExternalAppService {

    private final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private final String ALBUMS_URL = "https://jsonplaceholder.typicode.com/albums";

    public CompletableFuture<ResponseEntity<List<Post>>> getPostFuture() {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("ThreadName[Post]: " + Thread.currentThread().getName());
            return restTemplate.exchange(baseUrl + "/posts", HttpMethod.GET, entity,
                    new ParameterizedTypeReference<List<Post>>() {
                    });
        });
    }

    public CompletableFuture<ResponseEntity<List<Album>>> getAlbumFuture() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("ThreadName[Album]: " + Thread.currentThread().getName());
            return restTemplate.exchange(baseUrl + "/albums", HttpMethod.GET, entity,
                    new ParameterizedTypeReference<List<Album>>() {
                    });
        });
    }

}
