package com.lhz.dao;

import com.lhz.model.Person;

public interface PersonDao {

    void update();
    void delete();
    void change(Person user);
    Person query(String username);
}
