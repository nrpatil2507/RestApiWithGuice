package com.axelor.service;

import java.util.List;

import com.axelor.entity.Person;

public interface PersonService {
	void InsertData(Person person);

	void DisplayData();

	void DeleteData(Person p);

	Person FindPerson(int pid);

	void UpdateData(Person p);

	List<Person> Getallperson();

}
