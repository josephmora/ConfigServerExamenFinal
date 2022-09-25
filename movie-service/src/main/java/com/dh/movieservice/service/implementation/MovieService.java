package com.dh.movieservice.service.implementation;

import com.dh.movieservice.model.dto.MovieDTO;
import com.dh.movieservice.persistence.entity.Movie;
import com.dh.movieservice.persistence.repository.IMovieRepository;
import com.dh.movieservice.service.IMovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService implements IMovieService {


    IMovieRepository repositoryMovie;
    ObjectMapper mapper;

    @Autowired
    public MovieService(IMovieRepository repositoryMovie, ObjectMapper mapper) {
        this.repositoryMovie = repositoryMovie;
        this.mapper = mapper;
    }




    @Override
    public Set<MovieDTO> findByGenre(String genre) {
        List<Movie> movies = repositoryMovie.findByGenre(genre);
        Set<MovieDTO> moviesDTO = new HashSet<>();

        for(Movie movie : movies){
            moviesDTO.add(mapper.convertValue(movie, MovieDTO.class));
        }

        return moviesDTO;

    }

    @Override
    public void addMovie(MovieDTO movieDTO) {
        Movie movie = mapper.convertValue(movieDTO, Movie.class);
        repositoryMovie.save(movie);

    }
}
