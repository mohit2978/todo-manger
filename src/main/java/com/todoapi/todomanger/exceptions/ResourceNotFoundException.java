package com.todoapi.todomanger.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    private String message;
    private HttpStatus status;
}
