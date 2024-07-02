package com.course.restfulspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //toda vez que ocorrer essa exceção, vai retornar NTO FOUND
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(Long id) {
        super("Resource not found for id > " + id);
    }
}
