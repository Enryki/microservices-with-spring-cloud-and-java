package br.com.erudio.person_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.person_api.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{}
