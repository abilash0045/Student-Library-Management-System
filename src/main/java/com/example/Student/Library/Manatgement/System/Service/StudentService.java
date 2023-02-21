package com.example.Student.Library.Manatgement.System.Service;

import com.example.Student.Library.Manatgement.System.DTOs.StudentUpdateMobNoRequestDto;
import com.example.Student.Library.Manatgement.System.Enums.CardStatus;
import com.example.Student.Library.Manatgement.System.Model.Card;
import com.example.Student.Library.Manatgement.System.Model.Student;
import com.example.Student.Library.Manatgement.System.Repsoitory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String createUser(Student student){
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);
        student.setCard(card);
        studentRepository.save(student);
        return "Student and card created successfully";
    }
    public String getNameByEmail(String email){
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }
    public String updateMobNo(StudentUpdateMobNoRequestDto studentUpdateMobNoRequestDto){
        Student student = studentRepository.findById(studentUpdateMobNoRequestDto.getId()).get();
        student.setMobNo(studentUpdateMobNoRequestDto.getMobNo());
        studentRepository.save(student);
        return "Mobile Number Updated Successfully";
    }
}
