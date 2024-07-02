package com.course.restfulspringboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.restfulspringboot.math_operations.MathOperations;
import com.course.restfulspringboot.model.Math;


@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathOperations mathOperations;
    
    private final AtomicLong counter = new AtomicLong();
    // função que recebe o número e chama a função isNumeric
    // funções para cada operação
    @GetMapping("/sum/{num1}/{num2}")
    public Math sum
    (
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2
    ) {
        mathOperations.isNumeric(num1);
        mathOperations.isNumeric(num2);

        return new Math(counter.incrementAndGet(), mathOperations.sum(num1, num2));
    }

    @GetMapping("/minus/{num1}/{num2}")
    public Math minus
    (
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2
    ) {
        mathOperations.isNumeric(num1);
        mathOperations.isNumeric(num2);

        return new Math(counter.incrementAndGet(), mathOperations.minus(num1, num2));
    }

    @GetMapping("/division/{num1}/{num2}")
    public Math division
    (
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2
    ) {
        mathOperations.isNumeric(num1);
        mathOperations.isNumeric(num2);

        return new Math(counter.incrementAndGet(), mathOperations.division(num1, num2));
    }

    @GetMapping("/media/{num1}/{num2}")
    public Math average
    (
        @PathVariable(value = "num1") String num1,
        @PathVariable(value = "num2") String num2
    ) {
        mathOperations.isNumeric(num1);
        mathOperations.isNumeric(num2);

        return new Math(counter.incrementAndGet(), mathOperations.average(num1, num2));
    }

    @GetMapping("/square/{num1}")
    public Math square
    (
        @PathVariable(value = "num1") String num1
    ) {
        return new Math(counter.incrementAndGet(), mathOperations.square(num1));
    }
}

