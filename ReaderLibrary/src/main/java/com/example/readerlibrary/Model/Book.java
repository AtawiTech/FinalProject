package com.example.readerlibrary.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookid;
    @Column(unique = true)
    @NotEmpty(message = "username can not be empty")
    private String bookname;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String bookinfo;
    private Integer authorid;
}
