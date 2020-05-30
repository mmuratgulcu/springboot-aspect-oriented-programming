package com.gulcu.murat.service;

import java.util.List;

import com.gulcu.murat.entities.Person;

public interface PersonService {

	List<Person> findAll();
	Person save(Person person);
}
