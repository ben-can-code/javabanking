package com.coding.exercise.bankapp.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coding.exercise.bankapp.model.UserAccount;
import com.coding.exercise.bankapp.repository.UserAccountRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount account = userAccountRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new User(
            account.getUsername(),
            account.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority(account.getRole()))
        );
    }

    public UserAccount registerUser(String username, String rawPassword, String role,
                                    Long customerNumber, String fullName, String email) {
        if (userAccountRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already taken.");
        }
        if (customerNumber != null && userAccountRepository.existsByCustomerNumber(customerNumber)) {
            throw new IllegalArgumentException("A login already exists for customer number " + customerNumber + ".");
        }
        String encoded = passwordEncoder.encode(rawPassword);
        UserAccount account = new UserAccount(username, encoded, role, customerNumber, fullName, email);
        return userAccountRepository.save(account);
    }

    public UserAccount findByUsername(String username) {
        return userAccountRepository.findByUsername(username).orElse(null);
    }
}
