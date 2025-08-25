package br.com.erudio.person_api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.person_api.controllers.TestLogController;
import br.com.erudio.person_api.exception.ResourceNotFoundException;
import br.com.erudio.person_api.models.Person;
import br.com.erudio.person_api.repository.PersonRepository;

@Service
public class PersonServices {
    private Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());
    @Autowired
    PersonRepository personRepository;

    


    public List<Person> findAll(){
        logger.info("Finding all people!");
        return personRepository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding one Person!");
        return personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person){
        logger.info("Creating One Person!");
        return personRepository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating One Person!");
        Person entity = personRepository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")); 
       
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting One Person!");
        Person entity = personRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        personRepository.delete(entity);
    }
}
