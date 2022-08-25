package com.example.readerlibrary.Controller;

import com.example.readerlibrary.DTO.Api;
import com.example.readerlibrary.Model.Author;
import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/author")
public class AuthorController {


    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity getAuthors(){
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAuthor());
    }
    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Author added !",201));
    }
    @PutMapping("/edit")
    public ResponseEntity<Api> updateAuthor(@RequestBody Author author,@PathVariable Integer id){
        authorService.updateAuthor(author, id);
        return ResponseEntity.status(201).body(new Api("Author data updated !",201));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Api> deleteAuthor(@PathVariable Integer id){
        authorService.deleteAuthor(id);
        return ResponseEntity.status(201).body(new Api("Author deleted !",201));
    }

}

