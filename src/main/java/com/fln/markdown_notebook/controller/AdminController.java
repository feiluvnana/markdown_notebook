package com.fln.markdown_notebook.controller;

import com.fln.markdown_notebook.entity.User;
import com.fln.markdown_notebook.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class AdminController {
    public final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/user")
    public List<User> getUsers() {
        return adminService.findAll();
    }
}
