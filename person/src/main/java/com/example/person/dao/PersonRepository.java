package com.example.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
