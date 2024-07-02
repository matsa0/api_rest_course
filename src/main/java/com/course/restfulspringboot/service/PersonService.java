package com.course.restfulspringboot.service;

import java.util.List;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.restfulspringboot.dto_v1.PersonDTO;
import com.course.restfulspringboot.dto_v2.PersonDTO2;
import com.course.restfulspringboot.exception.ResourceNotFoundException;
import com.course.restfulspringboot.mapper.PersonMapper;
import com.course.restfulspringboot.mapper.PersonMapperV2;
import com.course.restfulspringboot.model.Person;
import com.course.restfulspringboot.repository.PersonRepository;


@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonDTO findById(Long id) {
        logger.info("Finding one person...");
        Person person = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));

        return PersonMapper.INSTANCE.personToPersonDTO(person);
    }

    public List<PersonDTO> findAll() {
        return repository.findAll().stream()
            .map(PersonMapper.INSTANCE::personToPersonDTO)
            .collect(Collectors.toList());
    }

    public PersonDTO create(Person person) {
        logger.info("Creating one person...");
        repository.save(person);
        return PersonMapper.INSTANCE.personToPersonDTO(person);
    }

    public PersonDTO2 createV2(Person person) {
        logger.info("Creating one person with v2...");
        repository.save(person);
        return PersonMapperV2.INSTANCE.personToPersonDTO2(person);
    }

    public PersonDTO update(Person person) {
        logger.info("Updating one person...");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException(person.getId()));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        
        repository.save(entity);

        return PersonMapper.INSTANCE.personToPersonDTO(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person...");
        try {
            repository.deleteById(id);
        } catch(RuntimeException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
