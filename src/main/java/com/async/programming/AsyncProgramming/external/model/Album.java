package com.async.programming.AsyncProgramming.external.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Album {

    private String userId;
    private String id;
    private String title;
}
