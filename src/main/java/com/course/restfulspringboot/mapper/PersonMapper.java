package com.course.restfulspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.course.restfulspringboot.dto_v1.PersonDTO;
import com.course.restfulspringboot.model.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "address", target = "address")
    PersonDTO personToPersonDTO(Person person);

 
}
