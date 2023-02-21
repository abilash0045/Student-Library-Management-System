package com.example.Student.Library.Manatgement.System.Repsoitory;

import com.example.Student.Library.Manatgement.System.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
