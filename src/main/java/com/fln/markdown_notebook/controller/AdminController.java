package com.fln.markdown_notebook.controller;

import com.fln.markdown_notebook.controller.request.CreateUserRequest;
import com.fln.markdown_notebook.entity.User;
import com.fln.markdown_notebook.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
class AdminController {
    public final AdminService adminService;

    @GetMapping("/admin/users")
    public List<User> getAllUsers() {
        return adminService.readAll();
    }

    @PostMapping("/admin/users")
    public User postUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return adminService.create(
            createUserRequest.username(),
            createUserRequest.password(),
            createUserRequest.role()
        );
    }
}
