package com.axelor.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.axelor.db.Person;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class PersonServiceImpl implements PersonService {
	@Inject
	Provider<EntityManager> em;

	@Override
	@Transactional
	public void InsertData(Person person) {
		em.get().persist(person);
	}

	@Override
	@Transactional
	public void DeleteData(int pid) {
		Person p = em.get().find(Person.class, pid);
		em.get().remove(p);
	}

	@Override
	@Transactional
	public Person FindPerson(int pid) {
		Person p = em.get().find(Person.class, pid);
		return p;
	}

	@Override
	@Transactional
	public void UpdateData(Person p, int id) {
		Person pdata = em.get().find(Person.class, id);
		pdata.setFname(p.getFname());
		pdata.setLname(p.getLname());
		pdata.setEmail(p.getEmail());
		pdata.setAdd(p.getAdd());
	}

	@Override
	@Transactional
	public List<Person> Getallperson() {
		List<Person> p = em.get().createQuery("from Person", Person.class).getResultList();
		return p;
	}

}
