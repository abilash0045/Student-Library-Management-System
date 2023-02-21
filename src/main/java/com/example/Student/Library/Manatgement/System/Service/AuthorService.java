package com.example.Student.Library.Manatgement.System.Service;

import com.example.Student.Library.Manatgement.System.DTOs.AuthorRequestDto;
import com.example.Student.Library.Manatgement.System.Model.Author;
import com.example.Student.Library.Manatgement.System.Repsoitory.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String add(AuthorRequestDto authorRequestDto){

        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setAge(authorRequestDto.getAge());
        author.setCountry(authorRequestDto.getCountry());
        authorRepository.save(author);
        return "Author added successfully";
    }
}
