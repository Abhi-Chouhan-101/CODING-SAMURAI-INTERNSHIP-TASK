package com.atm.Service;

import com.atm.Model.User;
import com.atm.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String accountNumber) throws UsernameNotFoundException {
        return userRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
