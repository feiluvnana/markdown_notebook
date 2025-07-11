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

    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(String username, String password, String role) {
        return userRepository.save(User.builder()
            .username(username)
            .password(passwordEncoder.encode(password))
            .role(User.UserRole.valueOf(role))
            .build());
    }

    public User updateUser(int id, String username, String password, String role) {
        final User.UserBuilder userBuilder = userRepository.findById(id).orElseThrow().toBuilder();
        if (username != null) userBuilder.username(username);
        if (password != null) userBuilder.password(passwordEncoder.encode(password));
        if (role != null) userBuilder.role(User.UserRole.valueOf(role));
        return userRepository.save(userBuilder.build());
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}

