package com.example.readerlibrary.Service;

import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Model.Review;
import com.example.readerlibrary.Repository.BookRepository;
import com.example.readerlibrary.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public void addReview(Review review, Book book) {
        review.setBookid(book.getBookid());
        reviewRepository.save(review);
    }

    public void deleteReview(Integer id) {
        Review review=reviewRepository.getById(id);
        reviewRepository.delete(review);
    }
    public List<Book> getReviewByBookid(Integer id){
        return bookRepository.findReviewByBookid(id);
    }

}
