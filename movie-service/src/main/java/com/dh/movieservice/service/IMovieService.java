package com.dh.movieservice.service;

import com.dh.movieservice.model.dto.MovieDTO;


import java.util.Set;

public interface IMovieService {
    Set<MovieDTO> findByGenre(String genre);
    void addMovie(MovieDTO movieDTO);
}
