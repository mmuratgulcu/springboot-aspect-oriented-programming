package com.gulcu.murat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gulcu.murat.dao.PersonRepository;
import com.gulcu.murat.entities.Person;
import com.gulcu.murat.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	private final PersonRepository personRepository;	
	
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> findAll() {
		List<Person> persons = personRepository.findAll();
		return persons;
	}

	@Override
	public Person save(Person p) {
		Person person = personRepository.save(p);
		return person;
	}

}
