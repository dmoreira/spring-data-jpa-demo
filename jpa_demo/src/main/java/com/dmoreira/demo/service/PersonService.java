package com.dmoreira.demo.service;

import java.util.List;

import com.dmoreira.demo.domain.Person;

public interface PersonService {
	Person save(Person p);
	 
	Person findOne(long id);
 
    List<Person> findAll();
 
    Long count();
 
    void delete(Person p);
     
    void deleteAll();
}
