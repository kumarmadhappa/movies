package com.kumar.movies.controllers;

import com.kumar.movies.models.Movie;
import com.kumar.movies.models.Review;
import com.kumar.movies.services.MovieService;
import com.kumar.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        String reviewBody = payload.get("reviewBody");
        String imdbId =  payload.get("imdbId");
        return new ResponseEntity<>(reviewService.createReview(reviewBody, imdbId), HttpStatus.CREATED);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<List<Review>> getAllReviewsForMovieByImdbId(@PathVariable String imdbId){
        Optional<Movie> movie = movieService.singleMovieByImdbId(imdbId);

        return new ResponseEntity<>(movie.orElse(new Movie()).getReviewIds(), HttpStatus.OK);
    }
}
