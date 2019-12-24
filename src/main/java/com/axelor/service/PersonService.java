package com.axelor.service;

import java.util.List;

import com.axelor.db.Contact;
import com.axelor.db.Person;
import com.axelor.db.Phone;

public interface PersonService {
	void InsertData(Person person);

	void DeleteData(int pid);

	Person FindPerson(int pid);

	Phone findPhone(int p);

	void UpdateData(Person p, int id);

	List<Person> Getallperson();

	void InsertPhone(Phone p, Contact c);

	int DeletePhone(int id);

	void updateCon(Phone p, Contact c);

}
