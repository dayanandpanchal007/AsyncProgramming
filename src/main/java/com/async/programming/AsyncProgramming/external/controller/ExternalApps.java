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
import java.util.*;
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

    @GetMapping("postpostmap")
    public HashMap<String, List<Post>> getPostsAndAlbumsWithMap() {
        var start = LocalTime.now();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        List<String> keys = Arrays.asList("post1", "post2", "post3", "post4", "post5");

        HashMap<String, List<Post>> resultMap = new HashMap<>();

        for (String key: keys) {
            ResponseEntity<List<Post>> postResponse = restTemplate.exchange(POSTS_URL, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<List<Post>>() {
                    });
            resultMap.put(key, postResponse.getBody());
        }

        var end = LocalTime.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Took " + duration.toMillis() + " ms for synchronous operation");
        return resultMap;
    }

    @GetMapping("asyncpostpostmap")
    public HashMap<String, List<Post>> getPostsAndAlbumsAsyncWithMap() {
        var start = LocalTime.now();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        Map<String, CompletableFuture<ResponseEntity<List<Post>>>> futureMap = new HashMap<>();
        futureMap.put("post1", externalAppService.getPostFuture());
        futureMap.put("post2", externalAppService.getPostFuture());
        futureMap.put("post3", externalAppService.getPostFuture());
        futureMap.put("post4", externalAppService.getPostFuture());
        futureMap.put("post5", externalAppService.getPostFuture());

        HashMap<String, List<Post>> resultMap = new HashMap<>();

        try {
            var future = CompletableFuture.allOf(futureMap.values().toArray(new CompletableFuture[0]))
                    .supplyAsync(() -> {
                        for (String key: futureMap.keySet()) {
                            try {
                                System.out.println("calling for " + key);
                                List<Post> posts = futureMap.get(key).get().getBody();
                                resultMap.put(key, posts);
                            } catch (InterruptedException | ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                        return resultMap;
                    });
            var end = LocalTime.now();
            Duration duration = Duration.between(start, end);
            System.out.println("Took " + duration.toMillis() + " ms for asynchronous operation");
            return future.thenApply((map) -> {
                var postsCall = CompletableFuture.supplyAsync(() -> restTemplate.exchange(POSTS_URL, HttpMethod.GET, entity,
                        new ParameterizedTypeReference<List<Post>>() {
                        }));
                try {
                    var posts = postsCall.get().getBody();
                    String key = "post6";
                    System.out.println("calling for " + key);
                    resultMap.put(key, posts);
                    return resultMap;
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    return null;
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

}
