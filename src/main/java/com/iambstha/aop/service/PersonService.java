package com.iambstha.aop.service;

import com.iambstha.aop.entity.Person;

public interface PersonService {

    Person getPersonById(Long id);

    Person savePerson(Person person);

}
