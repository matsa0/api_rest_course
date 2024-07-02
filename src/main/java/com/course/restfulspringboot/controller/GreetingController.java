package com.course.restfulspringboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.restfulspringboot.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //value é o que a gente quer passar, default é caso não passe nada
    @GetMapping
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World")
    String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
