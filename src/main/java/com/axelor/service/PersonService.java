package com.axelor.service;

import java.util.List;

import com.axelor.db.Person;

public interface PersonService {
	void InsertData(Person person);

	void DeleteData(int pid);

	Person FindPerson(int pid);

	void UpdateData(Person p, int id);

	List<Person> Getallperson();

}
