package dao;

import model.Customer;
import model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE Person "
				  + "SET FirstName=?, "
				  +     "LastName=?, "
				  + 	"Street=?, "
				  + 	"City=?, "
				  + 	"State=?, "
				  + 	"Zipcode=?, "
				  + 	"Email=?, "
				  + 	"Telephone=? "
				  + "WHERE SSN=?;");
			
			pstmt.setString(1, person.getFirstName());
			pstmt.setString(2, person.getLastName());
			pstmt.setString(3, person.getStreet());
			pstmt.setString(4, person.getCity());
			pstmt.setString(5, person.getState());
			pstmt.setInt(6, person.getZipCode());
			pstmt.setString(7, person.getEmail());
			pstmt.setString(8, person.getTelephone());
			pstmt.setString(9, person.getPersonID());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		return "success";
	}
	
	/**
	 * Delete a person in the database
	 * @param SSN of person to delete
	 * @return "success"|"failure"
	 */
	public String deletePerson(String ssn) {
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();
			String deletePerson= "DELETE FROM Person WHERE SSN='" + ssn + "';";
			
			st.executeUpdate(deletePerson);
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		return "success";
	}

}
