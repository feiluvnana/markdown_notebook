package com.fln.markdown_notebook.controller.admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record CreateUserRequest(
    @Length(min = 6, max = 30) @NotBlank String username,
    @Length(min = 6, max = 30) @NotBlank String password,
    @Pattern(regexp = "^USER|ADMIN$") @NotBlank String role
) {
}
