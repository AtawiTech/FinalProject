package com.example.readerlibrary.Repository;

import com.example.readerlibrary.Model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}
