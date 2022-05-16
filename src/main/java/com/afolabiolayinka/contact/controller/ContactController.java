package com.afolabiolayinka.contact.controller;

import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.afolabiolayinka.contact.entity.Contact;
import com.afolabiolayinka.contact.exception.EntityNotFoundException;
import com.afolabiolayinka.contact.repository.ContactRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class ContactController {
    private final ContactRepository repository;

    ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contacts")
    public List<Contact> doReadAll() {
        return repository.findAll();
    }

    @PostMapping("/contacts")
    public Contact doCreate(@Valid @RequestBody Contact contact) {
        return repository.save(contact);
    }

    @GetMapping("/contacts/{id}")
    public Contact doRead(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping("/contacts/{id}")
    public Contact doUpdate(@Valid @RequestBody Contact newContact, @PathVariable Long id) {

        Contact mContact = repository.findById(id).orElse(null);
        if (mContact == null) {
            throw new EntityNotFoundException();
        }

        newContact.setId(id);
        return repository.save(newContact);
    }

    @DeleteMapping("/contacts/{id}")
    public void doDelete(@PathVariable Long id) {
        Contact mContact = repository.findById(id).orElse(null);
        if (mContact == null) {
            throw new EntityNotFoundException();
        }

        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
