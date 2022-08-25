package com.example.readerlibrary.Controller;

import com.example.readerlibrary.DTO.Api;
import com.example.readerlibrary.Model.Author;
import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity getBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBook());
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody Book book){
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Book added !",201));
    }

            @PutMapping("/edit")
        public ResponseEntity<Api> updateBook(@RequestBody Book book,@PathVariable Integer id){
                bookService.updateBook(book, id);
            return ResponseEntity.status(201).body(new Api("Book data updated !",201));
        }
        @DeleteMapping("/delete")
    public ResponseEntity<Api> deleteBook(@PathVariable Integer id){
            bookService.deleteBook(id);
        return ResponseEntity.status(201).body(new Api("Book deleted !",201));
    }
}
