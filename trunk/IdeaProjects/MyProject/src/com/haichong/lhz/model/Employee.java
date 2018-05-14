package com.haichong.lhz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.Employee")
public class Employee {
    @Id
    @Column(name = "id")
    private int id;

}
