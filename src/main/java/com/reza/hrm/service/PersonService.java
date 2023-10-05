package com.reza.hrm.service;

import com.reza.hrm.model.Person;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    List<Person> people = new ArrayList<>();

    @PostConstruct
    public void init() {

        Person p1 = new Person();
        p1.setId(1L).setFullName("first person").setNationalCode("1234567890").setBirthDate(LocalDate.now());

        Person p2 = new Person();
        p2.setId(2L).setFullName("second person").setNationalCode("2345678901").setBirthDate(LocalDate.now());

        Person p3 = new Person();
        p3.setId(2L).setFullName("third person").setNationalCode("3456789012").setBirthDate(LocalDate.now());

        people.addAll(Arrays.asList(p1, p2, p3));
    }

    public Person findById(Long id) {
        return people.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Person not exist!"));
    }
}
