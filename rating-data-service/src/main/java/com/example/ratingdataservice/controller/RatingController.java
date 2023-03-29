package com.example.ratingdataservice.controller;

import com.example.ratingdataservice.model.Rating;
import com.example.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("user/{userId}")
    public UserRating getRatingList(@PathVariable String userId) {
        List<Rating> ratingList = Arrays.asList(
                new Rating("18", 4),
                new Rating("19", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setRatingList(ratingList);
        return userRating;
    }

}
