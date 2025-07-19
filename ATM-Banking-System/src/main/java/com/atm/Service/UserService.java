package com.atm.Service;

import com.atm.Config.JwtProvider;
import com.atm.Model.User;
import com.atm.Repository.UserRepository;
import com.atm.Request.LoginRequest;
import com.atm.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Encode PIN before saving
        user.setPin(passwordEncoder.encode(user.getPin()));
        return userRepo.save(user);
    }

    public JwtResponse loginUser(LoginRequest request) {
        User user = userRepo.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Invalid account number"));

        // Check PIN
        if (!passwordEncoder.matches(request.getPin(), user.getPin())) {
            throw new RuntimeException("Invalid PIN");
        }

        String token = jwtProvider.generateToken(user.getAccountNumber());

        return new JwtResponse(token, user.getAccountNumber(), user.getRole().name());
    }

    public User getUserByAccount(String accountNumber) {
        System.out.println("===> Balance endpoint called");
        return userRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }
}
