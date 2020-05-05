package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Bookdetails {
@Id
@GeneratedValue(strategy=GenerationType.TABLE)
private Integer bookid;
private String bookname;
private String status;
public Integer getBookid() {
	return bookid;
}
public void setBookid(Integer bookid) {
	this.bookid = bookid;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}


