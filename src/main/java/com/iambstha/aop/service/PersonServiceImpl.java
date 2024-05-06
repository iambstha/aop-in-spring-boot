package com.iambstha.aop.service;

import com.iambstha.aop.entity.Person;
import com.iambstha.aop.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonServiceImpl implements  PersonService  {

    @Autowired
    private final PersonRepository personRepository;

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        return optionalPerson.orElse(null);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
