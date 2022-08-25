package com.example.readerlibrary.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewid;
    @Column(unique = true,nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String body;
    private Integer bookid;
}
