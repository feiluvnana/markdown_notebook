package com.fln.markdown_notebook.controller.admin;

import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record UpdateUserRequest(
    @Length(min = 6, max = 30) String username,
    @Length(min = 6, max = 30) String password,
    @Pattern(regexp = "^USER|ADMIN$") String role
) {
}
