package com.example.Student.Library.Manatgement.System.Service;

import com.example.Student.Library.Manatgement.System.DTOs.BookRequestDto;
import com.example.Student.Library.Manatgement.System.Model.Author;
import com.example.Student.Library.Manatgement.System.Model.Book;
import com.example.Student.Library.Manatgement.System.Repsoitory.AuthorRepository;
import com.example.Student.Library.Manatgement.System.Repsoitory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    public String add(BookRequestDto bookRequestDto){
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        Book book = new Book();
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());
        book.setGenre(bookRequestDto.getGenre());
        book.setAuthor(author);
        List<Book> currBooks = author.getBooksWritten();
        currBooks.add(book);
        author.setBooksWritten(currBooks);
        authorRepository.save(author);
        return "book added successfully";
    }
}
