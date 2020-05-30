package com.gulcu.murat.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gulcu.murat.annotation.LogAnnotation;
import com.gulcu.murat.entities.Person;
import com.gulcu.murat.service.impl.PersonServiceImpl;

@RestController
@RequestMapping("/aop")
public class PersonController {

	private final PersonServiceImpl personService;

	public PersonController(PersonServiceImpl personService) {
		this.personService = personService;
	}
	
	@GetMapping("/person/all")
	public ResponseEntity<List<Person>> findAll(){
		return ResponseEntity.ok(personService.findAll());
	}
	
	@PostMapping("/person/save")
	public ResponseEntity<Person> save(@RequestBody Person person) {
		Person save = personService.save(person);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/status")
	@LogAnnotation
	public String status() {
		System.out.println("status metodu çalıştı");
		return "status up";
	}
}
