package com.axelor.db;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Person {
	@Id
	@GeneratedValue
	int pid;
	String fname;
	String lname;
	String email;
	String add;

	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	List<Phone> plist;

	public List<Phone> getPlist() {
		return plist;
	}

	public void setPlist(List<Phone> plist) {
		this.plist = plist;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", add=" + add
				+ "]";
	}

}
