package com.example.readerlibrary.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
public class DTO {

    private String bookname;
    private String bookinfo;
    private String authorname;
    private String nationality;
    private String username;
    private String password;
    private String role;
    private String title;
    private String body;
    private String adminName;
    private String readerName;
    private Integer userId;

}
