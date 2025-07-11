package com.fln.markdown_notebook.controller.admin;

import com.fln.markdown_notebook.entity.User;
import com.fln.markdown_notebook.service.AdminService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
class AdminController {
    public final AdminService adminService;

    @GetMapping("/admin/users")
    public List<User> readAllUsers() {
        return adminService.readAllUsers();
    }

    @PostMapping("/admin/users")
    public User createUser(@RequestBody @Valid CreateUserRequest request) {
        return adminService.createUser(
            request.username(), request.password(), request.role());
    }

    @PutMapping("/admin/users/{id}")
    public User updateUser(
        @PathVariable int id, @RequestBody @Valid UpdateUserRequest request) {
        return adminService.updateUser(
            id, request.username(), request.password(), request.role());
    }

    @DeleteMapping("/admin/users/{id}")
    public String deleteUser(@PathVariable int id) {
        adminService.deleteUser(id);
        return "success";
    }
}
