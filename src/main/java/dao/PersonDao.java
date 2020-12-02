package dao;

import model.Customer;
import model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";

	/**
	 * Add a person to the database
	 * @param person object containing information about a person to add to db
	 * @return "success"|"failure"
	 */
	public String addPerson(Person person) {
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO Person (SSN, Password, FirstName, LastName, Street, City, State, Zipcode, Email, Telephone)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			
			pstmt.setString(1, person.getPersonID());
			pstmt.setString(2, person.getPassword());
			pstmt.setString(3, person.getFirstName());
			pstmt.setString(4, person.getLastName());
			pstmt.setString(5, person.getStreet());
			pstmt.setString(6, person.getCity());
			pstmt.setString(7, person.getState());
			pstmt.setInt(8, person.getZipCode());
			pstmt.setString(9, person.getEmail());
			pstmt.setString(10, person.getTelephone());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
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
