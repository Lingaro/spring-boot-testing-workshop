package com.lingaro.web.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.security.RolesAllowed;
import java.util.logging.Logger;

@Service
public class PersonService {
    public static final Logger LOG = Logger.getLogger(PersonService.class.getName());

    private final PersonRepository personRepository;
    private final AuditLog auditLog;

    public PersonService(PersonRepository personRepository, AuditLog auditLog) {
        this.personRepository = personRepository;
        this.auditLog = auditLog;
    }

    @Transactional
    @RolesAllowed("ADMIN")
    public Person save(Person person) {
        LOG.fine("New person: " + person);
        if (personRepository.count() >= 5) {
            throw new IllegalArgumentException("Person limit reached");
        }
        Person saved = personRepository.save(person);
        auditLog.notify("Create person#" + saved.id);
        return saved;
    }
}
