package com.example.readerlibrary.Controller;

import com.example.readerlibrary.DTO.Api;

import com.example.readerlibrary.Model.Author;
import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Model.Review;
import com.example.readerlibrary.Service.ReviewService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity getReviews(){
        return ResponseEntity.status(200).body(reviewService.getReviews());
    }
    @PostMapping
    public ResponseEntity addReview(@RequestBody Review review, @AuthenticationPrincipal Book book){
        reviewService.addReview(review, book);
        return ResponseEntity.status(200).body("New review added !");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Api> deleteReview(@PathVariable Integer id){
        reviewService.deleteReview(id);
        return ResponseEntity.status(201).body(new Api("Review deleted !",201));
    }
    @GetMapping("/bookreview")
    public ResponseEntity getReviewByBookid( @AuthenticationPrincipal Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewByBookid(id));
    }


}
