package com.lingaro.web.person;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    public PersonController(PersonRepository personRepository, PersonService personService) {
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @GetMapping()
    public List<Person> list() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person add(@RequestBody Person person) {
        return personService.save(person);
    }
}
