package com.joao.services;

import com.joao.data.dto.PersonDTO;
import com.joao.exception.ResourceNotFoundException;
import com.joao.model.Person;
import com.joao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static com.joao.mapper.ObjectMapper.parseListObjects;
import static com.joao.mapper.ObjectMapper.parseObject;

@Service
public class PersonServices{

	private final AtomicLong counter = new AtomicLong();

	@Autowired
	PersonRepository repository;

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<PersonDTO> findAll(){
		logger.info("Creating list Person!");

		return parseListObjects(repository.findAll(), PersonDTO.class);
	}

	public PersonDTO findById(Long id){
		logger.info("Finding one Person!");

		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return parseObject(entity, PersonDTO.class);
	}

	public PersonDTO create(PersonDTO person){
		logger.info("Creating Person!");

		var entity = parseObject(person, Person.class);

		return parseObject(repository.save(entity), PersonDTO.class);
	}

	public PersonDTO update(PersonDTO person){
		logger.info("Updating one Person!");

		Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return parseObject(repository.save(entity), PersonDTO.class);
	}

	public void delete(Long id){
		logger.info("Deleting one Person!");

		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}

}