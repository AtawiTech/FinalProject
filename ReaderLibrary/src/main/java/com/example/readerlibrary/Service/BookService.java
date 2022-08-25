package com.example.readerlibrary.Service;

import com.example.readerlibrary.Model.Author;
import com.example.readerlibrary.Model.Book;
import com.example.readerlibrary.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBook(){
        return bookRepository.findAll();
    }
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    public void updateBook(Book book, Integer id) {
        Book oldBook = bookRepository.getById(id);
        oldBook.setBookname(book.getBookname());
        oldBook.setBookinfo(book.getBookinfo());
       bookRepository.save(oldBook);
    }
        public void deleteBook(Integer id) {
        Book myBook=bookRepository.getById(id);
        bookRepository.delete(myBook);
    }
        public List<Book> getBooksbyAuthor(Author author){
    return bookRepository.findBookByAuthorid(author.getAuthorid());
    }
    public void addBookToAuthor(Book book, Author author){
        book.setAuthorid(author.getAuthorid());
        bookRepository.save(book);
    }

}
