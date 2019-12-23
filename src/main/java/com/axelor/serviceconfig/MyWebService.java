package com.axelor.serviceconfig;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.jboss.resteasy.plugins.providers.html.View;

import com.axelor.entity.Person;
import com.axelor.service.PersonService;
import com.google.inject.Inject;

@Path("/")
public class MyWebService {
	@Inject
	PersonService ps;

	@POST
	@Path("/insert")
	public View add(@FormParam("fname") String name, @FormParam("lname") String lname, @FormParam("add") String add,
			@FormParam("email") String mail) {
		Person p1 = new Person();
		p1.setFname(name);
		p1.setLname(lname);
		p1.setAdd(add);
		p1.setEmail(mail);
		ps.InsertData(p1);
		System.out.println("inserted");
		List<Person> ls = ps.Getallperson();
		return new View("/display.jsp", ls, "data");
	}

	@GET
	@Path("/display")
	public View display() {
		List<Person> ls = ps.Getallperson();
		return new View("/display.jsp", ls, "data");
	}
}
