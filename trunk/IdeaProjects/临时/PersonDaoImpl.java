package com.lhz.dao;

import com.lhz.model.Person;
import com.lhz.util.Hibernate_Util;

public class PersonDaoImpl implements PersonDao{
    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void change(Person person) {
        Hibernate_Util.change(person);
    }

    @Override
    public Person query(String username) {
        return Hibernate_Util.query(username, 1);
    }
}
