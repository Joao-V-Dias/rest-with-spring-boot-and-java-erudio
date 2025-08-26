package com.joao;

import com.joao.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices{

	private final AtomicLong counter = new AtomicLong();

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String id){
		logger.info("Finding one Person!");

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Joao");
		person.setLastName("Dias");
		person.setAddress("Patrocinio");
		person.setGender("Masculino");

		return person;
	}
}