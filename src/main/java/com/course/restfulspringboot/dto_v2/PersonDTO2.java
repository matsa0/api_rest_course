package com.course.restfulspringboot.dto_v2;

import java.util.Date;

public record PersonDTO2(
    String firstName,
    String lastName,
    String gender,
    Date birthDate
) {
    
}
