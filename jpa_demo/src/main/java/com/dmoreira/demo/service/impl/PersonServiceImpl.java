package com.dmoreira.demo.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmoreira.demo.domain.Person;
import com.dmoreira.demo.repository.PersonRepository;
import com.dmoreira.demo.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Inject
	private PersonRepository repo;
	
	public Person save(Person p) {
		return repo.save(p);
	}

	public Person findOne(long id) {
		return repo.findOne(id);
	}

	public List<Person> findAll() {
		return repo.findAll();
	}

	public Long count() {
		return repo.count();
	}

	public void delete(Person p) {
		repo.delete(p);
	}

	public void deleteAll() {
		repo.deleteAll();
	}

}
