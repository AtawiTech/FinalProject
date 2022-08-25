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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorid;
    @Column(unique = true)
    @NotEmpty(message = "Book name can not be empty")
    private String authorname;
    @NotEmpty(message = "Nationality can not be empty")
    private String nationality;
    private Integer bookid;

}
