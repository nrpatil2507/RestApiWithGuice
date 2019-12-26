package com.axelor.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.jboss.resteasy.plugins.providers.html.View;

import com.axelor.db.Contact;
import com.axelor.db.Person;
import com.axelor.db.Phone;
import com.axelor.service.ContactService;
import com.axelor.service.PersonService;
import com.axelor.service.PhoneService;
import com.google.inject.Inject;

@Path("/")
public class PersonController {
	@Inject
	PersonService personService;
	@Inject
	PhoneService phoneService;

	@Inject
	ContactService contactService;

	@POST
	@Path("/insert")
	public void add(@Context HttpServletRequest req, @Context HttpServletResponse res) throws IOException {
		Person p1 = new Person();
		p1.setFname(req.getParameter("fname"));
		p1.setLname(req.getParameter("lname"));
		p1.setAdd(req.getParameter("add"));
		p1.setEmail(req.getParameter("email"));

		personService.InsertData(p1);
		List<Person> ls = personService.Getallperson();
		req.setAttribute("data", ls);
		res.sendRedirect("./display");
	}

	@GET
	@Path("/display")
	public View display() {
		List<Person> ls = personService.Getallperson();
		return new View("/display.jsp", ls, "data");
	}

	@POST
	@Path("/insertCon")
	public String addphone(@FormParam("sr") String sr, @FormParam("phone_type") String pt,
			@FormParam("person_id") String id, @FormParam("cno") String cno) {
		Contact c = new Contact();
		Phone p = new Phone();
		int pid = Integer.parseInt(id);
		Person p1 = personService.FindPerson(pid);
		c.setCno(cno);

		p.setPhone_type(pt);
		p.setService_provider(sr);
		p.setContact(c);
		p.setPerson(p1);

		contactService.insertContact(c);
		phoneService.insertPhone(p);
		return "added successfully";
	}

	@GET
	@Path("/up/{id}")
	public View update(@PathParam("id") String id) {
		Person p;
		int pid = Integer.parseInt(id);
		p = personService.FindPerson(pid);
		return new View("/update.jsp", p, "data");
	}

	@POST
	@Path("/update")
	public void updatePerson(@Context HttpServletRequest req, @Context HttpServletResponse res) throws IOException {
		Person p1 = new Person();
		int pid = Integer.parseInt(req.getParameter("id"));
		p1.setFname(req.getParameter("fname"));
		p1.setLname(req.getParameter("lname"));
		p1.setAdd(req.getParameter("add"));
		p1.setEmail(req.getParameter("email"));
		personService.UpdateData(p1, pid);
		List<Person> ls = personService.Getallperson();
		req.setAttribute("data", ls);
		res.sendRedirect("./display");

	}

	@GET
	@Path("/delete/{pid}")
	public void delete(@PathParam("pid") int id, @Context HttpServletRequest req, @Context HttpServletResponse res)
			throws IOException {
		personService.DeleteData(id);
		res.sendRedirect("../display");
	}

	@GET
	@Path("/showContact/{pid}")
	public View showcon(@PathParam("pid") int pid) {
		Person p = personService.FindPerson(pid);
		return new View("/showContact.jsp", p, "data");
	}

	@GET
	@Path("/addphone")
	public View disphone() {
		List<Person> ls = personService.Getallperson();
		return new View("/addPhone.jsp", ls, "data");
	}

	@GET
	@Path("/deleteCon/{id}")
	public void delcon(@PathParam("id") int phid, @Context HttpServletRequest req, @Context HttpServletResponse res)
			throws IOException {
		Phone p = phoneService.findPhone(phid);
		phoneService.deletePhone(p);
		res.sendRedirect("../display");
	}

	@GET
	@Path("/upCon/{cid}")
	public void upCon(@PathParam("cid") int cid, @Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException {

		Phone phone = phoneService.findPhone(cid);
		request.setAttribute("phone_id", cid);
		request.setAttribute("phone_obj", phone);
		request.getRequestDispatcher("../updateCon.jsp").forward(request, response);
	}

	@POST
	@Path("/updateCon")
	public void updatecon(@Context HttpServletRequest request, @Context HttpServletResponse res) throws IOException {

		Phone phone = phoneService.findPhone(Integer.parseInt(request.getParameter("pid")));
		phone.setPhone_type(request.getParameter("pt"));
		phone.setService_provider(request.getParameter("sr"));
		Contact c = phone.getContact();
		c.setCno(request.getParameter("cno"));
		contactService.updateContact(c);

		phoneService.updatePhone(phone);
		res.sendRedirect("./display");
	}

}
