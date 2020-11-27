package dao;

import model.Customer;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao {

	/**
	 * Add a person to the database
	 * @param person object containing information about a person to add to db
	 * @return "success"|"failure"
	 */
	public String addPerson(Person person) {
		return "success";
	}
	
	/**
	 * Edit a person in the database
	 * @param person object containing updated information about person to edit
	 * @return "success"|"failure"
	 */
	public String editPerson(Person person) {
		return "success";
	}
	
	/**
	 * Delete a person in the database
	 * @param SSN of person to delete
	 * @return "success"|"failure"
	 */
	public String deletePerson(String ssn) {
		return "success";
	}

}
