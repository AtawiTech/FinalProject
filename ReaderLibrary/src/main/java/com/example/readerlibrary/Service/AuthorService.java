package com.example.readerlibrary.Service;

import com.example.readerlibrary.Model.Author;
import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
    public void updateAuthor(Author author, Integer id) {
        Author oldAuthor = authorRepository.getById(id);
        oldAuthor.setAuthorname(author.getAuthorname());
        oldAuthor.setNationality(author.getNationality());
        authorRepository.save(oldAuthor);
    }
    public void deleteAuthor(Integer id) {
        Author myAuthor=authorRepository.getById(id);
        authorRepository.delete(myAuthor);
    }
        public List<Author> getAuthorbyBook(Book book){
        return authorRepository.findAuthorByBookid(book.getBookid());
    }
    public void addAuthorToBook(Author author, Book book){
        book.setAuthorid(author.getAuthorid());
        authorRepository.save(author);
    }
}
