package com.kumar.movies.services;

import com.kumar.movies.repositories.MovieRepository;
import com.kumar.movies.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
