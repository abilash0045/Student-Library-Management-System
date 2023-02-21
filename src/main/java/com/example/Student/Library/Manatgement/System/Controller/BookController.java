package com.example.Student.Library.Manatgement.System.Controller;

import com.example.Student.Library.Manatgement.System.DTOs.BookRequestDto;
import com.example.Student.Library.Manatgement.System.Model.Book;
import com.example.Student.Library.Manatgement.System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Book")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.add(bookRequestDto);
    }
}
