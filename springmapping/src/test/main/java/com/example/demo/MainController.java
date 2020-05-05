package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@CrossOrigin(origins = "*")

@RequestMapping(path="/demo")
public class MainController {


@Autowired

private UserRepository userrepos;



@GetMapping(path="/all")

public Iterable<User> getAllUsers() {

  // This returns a JSON or XML with the users

  return userrepos.findAll();

}



@GetMapping(path="/all/{id}")

public Optional<User> getUserbyId(@PathVariable(value="id") Integer empid ) {

  // This returns a JSON or XML with the users

  return userrepos.findById(empid);

}



@PostMapping(path="/add")

public String addNewUser (@RequestBody User u) {

	    	    

		User n = new User();
n.setFirstname(u.getFirstname());

n.setLastname(u.getLastname());
n.setUserdetail(u.getUserdetail());
n.setBookdetail(u.getBookdetail());
n.setCoursedetail(u.getCoursedetail());
 
		    userrepos.save(n);

		    return "Saved";	    

	}



	@PutMapping(path="/{id}")

	public String 
	updateUser(@PathVariable(value="id") Integer empid, @RequestBody User user) {
 
		

		User u= userrepos.getOne(empid);

		u.setFirstname(user.getFirstname());

		u.setLastname(user.getLastname());

		userrepos.save(u);

		return "Updated the employee";
	}



	@DeleteMapping(path="/{id}")

	public String deleteUser(@PathVariable(value="id") Integer empid) {

		User u=userrepos.getOne(empid);

		userrepos.deleteById(empid);

		return "The user"+ u.getFirstname()+" "+u.getLastname()+" has been deleted";

		}
}
