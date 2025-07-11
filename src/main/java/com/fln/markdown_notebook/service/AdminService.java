package com.fln.markdown_notebook.service;

import com.fln.markdown_notebook.entity.User;
import com.fln.markdown_notebook.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public User create(String username, String password, String role) {
        return userRepository.save(User.builder()
            .username(username)
            .password(passwordEncoder.encode(password))
            .role(User.UserRole.valueOf(role))
            .build());
    }
}

