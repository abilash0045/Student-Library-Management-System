package com.example.Student.Library.Manatgement.System.Controller;

import com.example.Student.Library.Manatgement.System.DTOs.IssueBookRequestDto;
import com.example.Student.Library.Manatgement.System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
        return transactionService.issueBook(issueBookRequestDto);
    }
}
