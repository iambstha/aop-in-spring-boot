package com.iambstha.aop.resource;

import com.iambstha.aop.annotate.LogActivity;
import com.iambstha.aop.entity.Person;
import com.iambstha.aop.repository.PersonRepository;
import com.iambstha.aop.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class PersonResource {

    @Autowired
    private final PersonService personService;

    @PostMapping
    @LogActivity(entity = Person.class, repository = PersonRepository.class, activity = "add")
    public Person save(@RequestBody Person person){
        return personService.savePerson(person);
    }

    @GetMapping("/{id}")
    @LogActivity(entity = Person.class, repository = PersonRepository.class, remark = "Test remark")
    public  Person getPersonById(@PathVariable("id") Long id){
        return personService.getPersonById(id);
    }

}
