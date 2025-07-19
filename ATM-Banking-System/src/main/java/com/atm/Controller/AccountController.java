package com.atm.Controller;

import com.atm.Model.Transaction;
import com.atm.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AccountController {

    private final TransactionService transactionService;

    @PostMapping("/deposit")
    public Transaction deposit(@RequestParam Double amount, Authentication auth) {
        return transactionService.deposit(auth.getName(), amount);
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestParam Double amount, Authentication auth) {
        return transactionService.withdraw(auth.getName(), amount);
    }

    @GetMapping("/balance")
    public Double getBalance(Authentication auth) {
        return transactionService.checkBalance(auth.getName());
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(Authentication auth) {
        return transactionService.getTransactionHistory(auth.getName());
    }
}
