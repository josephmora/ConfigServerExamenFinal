package com.dh.movieservice.persistence.repository;

import com.dh.movieservice.persistence.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {
    @Query
    List<Movie> findByGenre(String genre);
}
