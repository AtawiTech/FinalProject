package com.example.readerlibrary.Service;

import com.example.readerlibrary.Model.Author;
import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Repository.AuthorRepository;
import com.example.readerlibrary.Repository.CommonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service @RequiredArgsConstructor
public class CommonService {


    private final CommonRepository commonRepository;
    private final AuthorRepository authorRepository;
    public List<Book> getBooksbyAuthor(Author author){
    return commonRepository.findBookByAuthorid(author.getAuthorid());
    }
    public void addBookToAuthor(Book book, Author author){
        book.setAuthorid(author.getAuthorid());
        commonRepository.save(book);
    }
    public List<Author> getAuthorbyBook(Book book){
        return authorRepository.findAuthorByBookid(book.getBookid());
    }
    public void addAuthorToBook(Author author, Book book){
        book.setAuthorid(author.getAuthorid());
        authorRepository.save(author);
    }
}
