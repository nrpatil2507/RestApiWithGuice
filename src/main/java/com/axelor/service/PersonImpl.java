package com.axelor.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.axelor.entity.Person;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class PersonImpl implements PersonService {
	@Inject
	Provider<EntityManager> em;

	@Override
	@Transactional
	public void InsertData(Person person) {
		em.get().persist(person);
	}

	@Override
	public void DisplayData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteData(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Person FindPerson(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void UpdateData(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Person> Getallperson() {
		List<Person> p = em.get().createQuery("from Person", Person.class).getResultList();
		return p;
	}

}
