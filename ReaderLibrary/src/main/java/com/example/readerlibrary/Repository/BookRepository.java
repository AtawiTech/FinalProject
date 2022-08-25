package com.example.readerlibrary.Repository;

import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findReviewByBookid(Integer id);

    List<Book> findBookByAuthorid(Integer id);
}
