package com.afolabiolayinka.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @GetMapping(value = "/", produces = "application/json")
    @ResponseBody
    public String index() {
        return "{\"name\":\"Contact API v0.1.0\"}";
    }
}
