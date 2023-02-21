package com.example.Student.Library.Manatgement.System.Controller;

import com.example.Student.Library.Manatgement.System.DTOs.AuthorRequestDto;
import com.example.Student.Library.Manatgement.System.Model.Author;
import com.example.Student.Library.Manatgement.System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String add(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.add(authorRequestDto);
    }
}
