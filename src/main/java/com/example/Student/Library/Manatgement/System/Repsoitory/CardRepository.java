package com.example.Student.Library.Manatgement.System.Repsoitory;

import com.example.Student.Library.Manatgement.System.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {
}
