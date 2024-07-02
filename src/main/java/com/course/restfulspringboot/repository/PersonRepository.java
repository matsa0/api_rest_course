package com.course.restfulspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.restfulspringboot.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
