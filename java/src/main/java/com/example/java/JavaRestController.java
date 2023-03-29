package com.example.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaRestController {
    @GetMapping
    public Message root() {
        return new Message("Text with \"double quotes\"");
    }
}

record Message(String text) {
}
