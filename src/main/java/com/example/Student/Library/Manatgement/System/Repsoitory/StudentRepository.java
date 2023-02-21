package com.example.Student.Library.Manatgement.System.Repsoitory;

import com.example.Student.Library.Manatgement.System.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);
}
