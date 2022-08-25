package com.example.readerlibrary.Controller;

import com.example.readerlibrary.DTO.Api;
import com.example.readerlibrary.Model.Author;
import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/common")
public class CommonController {

    private final CommonService commonService;

    @GetMapping("/books")
    public ResponseEntity getBooksbyAuthor( @AuthenticationPrincipal Author author){
        return ResponseEntity.status(HttpStatus.OK).body(commonService.getBooksbyAuthor(author));
    }
    @PostMapping("/books")
    public ResponseEntity addBookToAuthor(@RequestBody Book book, @AuthenticationPrincipal Author author){
        commonService.addBookToAuthor(book,author);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Book added !",201));
    }
    @GetMapping("/author")
    public ResponseEntity getAuthorbyBook( @AuthenticationPrincipal Book book){
        return ResponseEntity.status(HttpStatus.OK).body(commonService.getAuthorbyBook(book));
    }
    @PostMapping("/author")
    public ResponseEntity addAuthorToBook(@RequestBody Author author, @AuthenticationPrincipal Book book){
        commonService.addAuthorToBook(author,book);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Book added !",201));
    }

}
