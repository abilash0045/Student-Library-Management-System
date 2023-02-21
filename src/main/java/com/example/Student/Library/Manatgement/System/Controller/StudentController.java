package com.example.Student.Library.Manatgement.System.Controller;

import com.example.Student.Library.Manatgement.System.DTOs.StudentUpdateMobNoRequestDto;
import com.example.Student.Library.Manatgement.System.Model.Student;
import com.example.Student.Library.Manatgement.System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createUser(@RequestBody Student student){
        return studentService.createUser(student);
    }
    @GetMapping
    public String getNameByEmail(@RequestParam String email){
        return studentService.getNameByEmail(email);
    }
    @PutMapping
    public String updateMobNo(@RequestBody StudentUpdateMobNoRequestDto studentUpdateMobNoRequestDto){
        return studentService.updateMobNo(studentUpdateMobNoRequestDto);
    }
}

