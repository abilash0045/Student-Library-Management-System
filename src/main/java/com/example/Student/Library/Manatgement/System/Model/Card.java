package com.example.Student.Library.Manatgement.System.Model;

import com.example.Student.Library.Manatgement.System.Enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    Date createdOn;
    @UpdateTimestamp
    Date updatedOn;
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;
    @OneToOne
    @JoinColumn
    private Student student;
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> booksIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public Card() {
    }

    public Card(int id, Date createdOn, Date updatedOn, CardStatus cardStatus) {
        this.id = id;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.cardStatus = cardStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
