package com.dmoreira.demo.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.dmoreira.demo.domain.Person;
import com.dmoreira.demo.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
public class DemoTests {

	@Inject
	private PersonService service;
	
	@Test
	public void runTests() {
		savePerson();
		findPersonById();
		findPersonByAll();
		count();
		delete();
		deleteAll();
	}

	public void savePerson() {
		Person p1 = new Person("John", "Smith", 35);
		p1 = service.save(p1);
		Person p2 = new Person("Mary", "Perry", 24);
		p2 = service.save(p2);
		Person p3 = new Person("Willian", "Knight", 17);
		p3 = service.save(p3);
		Person p4 = new Person("Martin", "Wallace", 48);
		p4 = service.save(p4);
		Person p5 = new Person("Jerry", "Reed", 39);
		p5 = service.save(p5);
		Assert.assertEquals(5, p5.getId());
	}
	
	public void findPersonById() {
		Person p = service.findOne(1);
		Assert.assertEquals("John", p.getFirstName());
	}
	
	public void findPersonByAll() {
		int count = service.findAll().size();
		Assert.assertEquals(5, count);
	}
	
	public void count() {
		long count = service.count();
		Assert.assertEquals(5, count);
	}
	
	public void delete() {
		Person p = service.findOne(1);
		service.delete(p);
		long count = service.count();
		Assert.assertEquals(4, count);
	}
	
	public void deleteAll() {
		service.deleteAll();
		long count = service.count();
		Assert.assertEquals(0, count);
	}

}
