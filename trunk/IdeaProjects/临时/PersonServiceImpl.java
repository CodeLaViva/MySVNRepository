package com.lhz.service;

import com.lhz.dao.PersonDao;
import com.lhz.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "personService")
public class PersonServiceImpl implements PersonService{
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao userDao) {
        this.personDao = userDao;
    }

    @Override
    public Person query(String username) {
        return personDao.query(username);
    }

    @Override
    public void change(Person person) {
        personDao.change(person);
    }
}
