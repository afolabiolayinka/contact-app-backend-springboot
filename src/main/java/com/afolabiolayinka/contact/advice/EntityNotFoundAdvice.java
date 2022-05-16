package com.afolabiolayinka.contact.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.afolabiolayinka.contact.exception.EntityNotFoundException;

import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class EntityNotFoundAdvice {

  @ExceptionHandler(EntityNotFoundException.class)
  ResponseEntity<Object> entityNotFoundHandler(EntityNotFoundException ex) {
    return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
  }
}