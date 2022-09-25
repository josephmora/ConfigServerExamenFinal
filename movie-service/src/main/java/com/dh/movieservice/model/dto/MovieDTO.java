package com.dh.movieservice.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

    public MovieDTO() {
    }
}
