package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="Fname")
	private String firstname;
	private String lastname;
	@OneToOne(cascade= CascadeType.ALL)
	UserDetails userdetail;
	
	@OneToMany(targetEntity=Bookdetails.class,cascade=CascadeType.ALL)
	List<Bookdetails>bookdetail;
	
	@OneToMany(targetEntity=Coursedetails.class,cascade=CascadeType.ALL)
	List<Coursedetails>coursedetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public UserDetails getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetails userdetail) {
		this.userdetail = userdetail;
	}

	public List<Bookdetails> getBookdetail() {
		return bookdetail;
	}

	public void setBookdetail(List<Bookdetails> bookdetail) {
		this.bookdetail = bookdetail;
	}

	public List<Coursedetails> getCoursedetail() {
		return coursedetail;
	}

	public void setCoursedetail(List<Coursedetails> coursedetail) {
		this.coursedetail = coursedetail;
	}
	

}

