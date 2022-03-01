package com.async.programming.AsyncProgramming.external.controller;

import com.async.programming.AsyncProgramming.external.model.Album;
import com.async.programming.AsyncProgramming.external.model.Post;
import com.async.programming.AsyncProgramming.external.model.PostAlbumResponse;
import com.async.programming.AsyncProgramming.external.service.ExternalAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class ExternalApps {

    private final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private final String ALBUMS_URL = "https://jsonplaceholder.typicode.com/albums";

    @Autowired
    private ExternalAppService externalAppService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<List<Post>> response = restTemplate.exchange(POSTS_URL, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Post>>() {
                });
        return response;
    }

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<List<Album>> response = restTemplate.exchange(ALBUMS_URL, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Album>>() {
                });
        return response;
    }

    @GetMapping("postalbums")
    public PostAlbumResponse getPostAlbums() {
        var start = LocalTime.now();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<List<Post>> postResponse = restTemplate.exchange(POSTS_URL, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Post>>() {
                });
        ResponseEntity<List<Album>> albumResponse = restTemplate.exchange(ALBUMS_URL, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Album>>() {
                });
        PostAlbumResponse response = PostAlbumResponse.builder()
                .posts(postResponse.getBody())
                .albums(albumResponse.getBody())
                .build();
        System.out.println("threadName: " + Thread.currentThread().getName());
        var end = LocalTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Took " + duration.toMillis() + " ms for synchronous operation");
        return response;
    }

    @GetMapping("/asyncPosts")
    public List<Post> getPostsAsync() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        var postsCall = CompletableFuture.supplyAsync(() -> restTemplate.exchange(POSTS_URL, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Post>>() {
                }));
        try {

            ResponseEntity<List<Post>> posts = postsCall.get();
            return posts.getBody();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @GetMapping("/asyncAlbums")
    public List<Album> getAlbumsAsync() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        var albumsCall = CompletableFuture.supplyAsync(() -> restTemplate.exchange( ALBUMS_URL, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Album>>() {
                }));
        try {

            ResponseEntity<List<Album>> albums = albumsCall.get();
            return albums.getBody();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @GetMapping("/asyncpostalbum")
    public PostAlbumResponse getPostsAndAlbumsAsync() {
        var start = LocalTime.now();
        var postFuture = externalAppService.getPostFuture();
        var albumFuture = externalAppService.getAlbumFuture();
        try {
            var future = CompletableFuture.allOf(postFuture, albumFuture)
                    .supplyAsync(() -> {
                        try {
                            PostAlbumResponse response = PostAlbumResponse.builder()
                                    .posts(postFuture.get().getBody())
                                    .albums(albumFuture.get().getBody())
                                    .build();
                            return response;
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                            return null;
                        }
                    });
            var end = LocalTime.now();
            Duration duration = Duration.between(start, end);
            System.out.println("Took " + duration.toMillis() + " ms for asynchronous operation");
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

}
