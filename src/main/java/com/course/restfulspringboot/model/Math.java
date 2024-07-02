package com.course.restfulspringboot.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Math {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private final Long id;
    private final Double result;

}
