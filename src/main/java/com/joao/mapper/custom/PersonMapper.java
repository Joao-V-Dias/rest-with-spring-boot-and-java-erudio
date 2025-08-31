package com.joao.mapper.custom;

import com.joao.data.dto.v2.PersonDTOV2;
import com.joao.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper{

	public PersonDTOV2 convertEntitytoDTO(Person person){
		PersonDTOV2 dto = new PersonDTOV2();
		dto.setId(person.getId());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setBirthDay(new Date());
		dto.setAddress(person.getAddress());
		dto.setGender(person.getGender());

		return dto;
	}

	public Person convertDTOToEntity(PersonDTOV2 person){
		Person dto = new Person();
		dto.setId(person.getId());
		dto.setFirstName(person.getFirstName());
		dto.setLastName(person.getLastName());
		dto.setAddress(person.getAddress());
		dto.setGender(person.getGender());

		return dto;
	}
}