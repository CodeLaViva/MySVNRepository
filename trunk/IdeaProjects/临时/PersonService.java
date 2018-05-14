package com.lhz.service;

import com.lhz.model.Person;

public interface PersonService {
    Person query(String username);
    void change(Person person);
}
