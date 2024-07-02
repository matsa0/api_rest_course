package com.course.restfulspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.course.restfulspringboot.dto_v2.PersonDTO2;
import com.course.restfulspringboot.model.Person;

@Mapper
public interface PersonMapperV2 {
    PersonMapperV2 INSTANCE = Mappers.getMapper(PersonMapperV2.class);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(target = "birthDate", expression = "java(new Date())")
    PersonDTO2 personToPersonDTO2(Person person);
}
