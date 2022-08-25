package com.example.readerlibrary.Repository;


import com.example.readerlibrary.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByAuthorid(Integer id);

}
