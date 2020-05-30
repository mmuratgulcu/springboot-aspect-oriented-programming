package com.gulcu.murat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Person {
	@Id
	@SequenceGenerator(name = "person_gen",sequenceName = "person_seq",allocationSize = 1)
	@GeneratedValue(generator = "person_gen",strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private String surname;
	
	
	public Person() {

	}
	
	public Person( String name, String surname) {
		this(null,name,surname);
	}
	
	public Person(Integer id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}



	
}
