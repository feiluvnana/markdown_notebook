package com.fln.markdown_notebook.controller.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
class GlobalExceptionHandler {
    final ObjectMapper mapper;

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) throws JsonProcessingException {
        return mapper.writer().withDefaultPrettyPrinter().writeValueAsString(e);
    }
}
