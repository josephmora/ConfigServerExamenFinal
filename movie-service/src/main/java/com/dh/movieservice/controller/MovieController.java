package com.dh.movieservice.controller;

import com.dh.movieservice.model.dto.MovieDTO;
import com.dh.movieservice.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    IMovieService movieService;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<Set<MovieDTO>> findMoviesByGenre(@PathVariable("genre") String genre){
        return ResponseEntity.ok(movieService.findByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDto){
        ResponseEntity<MovieDTO> response = null;
        if (movieDto.getId() == null){
            movieService.addMovie(movieDto);
            response = ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

}
