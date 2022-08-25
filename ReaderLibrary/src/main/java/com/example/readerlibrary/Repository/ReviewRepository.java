package com.example.readerlibrary.Repository;

import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findReviewByBookid(Integer id);
}
