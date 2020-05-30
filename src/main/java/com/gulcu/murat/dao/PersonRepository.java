package com.gulcu.murat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gulcu.murat.entities.Person;

public interface PersonRepository extends JpaRepository<Person,Integer>{

}
