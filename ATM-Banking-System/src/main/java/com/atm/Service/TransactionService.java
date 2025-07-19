package com.atm.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.atm.Model.Transaction;
import com.atm.Model.User;
import com.atm.Repository.TransactionRepository;

import com.atm.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository
            transactionRepo;
    private final UserRepository userRepo;

    @Transactional
    public Transaction deposit(String accountNumber, Double amount) {
        User user = userRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setBalance(user.getBalance() + amount);

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAmount(amount);
        transaction.setType("DEPOSIT");
        transaction.setPostBalance(user.getBalance());
        transaction.onCreate();

        transactionRepo.save(transaction);
        userRepo.save(user);

        return transaction;
    }

    @Transactional
    public Transaction withdraw(String accountNumber, Double amount) {
        User user = userRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        user.setBalance(user.getBalance() - amount);

        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setAmount(amount);
        transaction.setType("WITHDRAW");
        transaction.setPostBalance(user.getBalance());
        transaction.onCreate();

        transactionRepo.save(transaction);
        userRepo.save(user);

        return transaction;
    }

    public Double checkBalance(String accountNumber) {
        User user = userRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
//        System.out.println("=========="+user.getBalance());
        return user.getBalance();
    }

    public List<Transaction> getTransactionHistory(String accountNumber) {
        User user = userRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return transactionRepo.findByUser(user);
    }
}
