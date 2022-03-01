package com.async.programming.AsyncProgramming.external.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostAlbumResponse {

    List<Post> posts;
    List<Album> albums;
}
