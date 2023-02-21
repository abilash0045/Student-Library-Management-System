package com.example.Student.Library.Manatgement.System.Service;

import com.example.Student.Library.Manatgement.System.DTOs.IssueBookRequestDto;
import com.example.Student.Library.Manatgement.System.Enums.TransactionStatus;
import com.example.Student.Library.Manatgement.System.Model.Book;
import com.example.Student.Library.Manatgement.System.Model.Card;
import com.example.Student.Library.Manatgement.System.Model.Transaction;
import com.example.Student.Library.Manatgement.System.Repsoitory.BookRepository;
import com.example.Student.Library.Manatgement.System.Repsoitory.CardRepository;
import com.example.Student.Library.Manatgement.System.Repsoitory.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public String issueBook(IssueBookRequestDto issueBookRequestDto){
        Book book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        Card card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        Transaction transaction = new Transaction();
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        List<Transaction> bookTransactions = book.getTransactions();
        bookTransactions.add(transaction);
        book.setTransactions(bookTransactions);
        List<Book> booksIssued = card.getBooksIssued();
        booksIssued.add(book);
        card.setBooksIssued(booksIssued);
        List<Transaction> cardTransactions = card.getTransactions();
        cardTransactions.add(transaction);
        card.setTransactions(cardTransactions);

        bookRepository.save(book);
        cardRepository.save(card);
        return "Book issued successfully";
    }
}
