package com.dmoreira.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmoreira.demo.domain.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {

}
