package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Profile;
import model.Customer;

import java.util.stream.IntStream;

public class CustomerDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";
	static final String DB_USER = "root";
	static final String DB_PASS = "root";
	
	
	/**
	 * @return ArrayList<Customer> object
	 */
	public List<Customer> getCustomers() {
		/*
		 * This method fetches one or more customers and returns it as an ArrayList
		 */
		
		List<Customer> customers = new ArrayList<Customer>();
		String query = ""
				+ "SELECT P.SSN, FirstName, LastName, Street, City, State, Zipcode, Telephone, "
				+ "Email, AcctNum, AcctCreateDate, PPP, DateOfLastAct, CardNumber, Rating, Password "
				+ "FROM Person P, Account A, User U "
				+ "WHERE P.SSN = A.OwnerSSN AND P.SSN = U.SSN";
		ResultSet r = executeSelectQuery(query);
		
		if (r == null) {
			return null;
		}
		
		try {
			while (r.next()) {
				Customer customer = new Customer();
				customer.setUserID(r.getString("SSN"));
				customer.setUserSSN(r.getString("SSN"));
				customer.setFirstName(r.getString("FirstName"));
				customer.setLastName(r.getString("LastName"));
				customer.setAddress(r.getString("Street"));
				customer.setCity(r.getString("City"));
				customer.setState(r.getString("State"));
				customer.setZipCode(r.getInt("Zipcode"));
				customer.setTelephone(r.getString("Telephone"));
				customer.setEmail(r.getString("Email"));
				customer.setAccNum(r.getString("AcctNum"));
				customer.setAccCreateDate(r.getString("AcctCreateDate"));
				customer.setPpp(r.getString("PPP"));
				customer.setDateLastActive(r.getString("DateOfLastAct"));
				customer.setCreditCard(r.getString("CardNumber"));
				customer.setRating(r.getInt("Rating"));
				customer.setPassword(r.getString("Password"));
				customers.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		return customers;
	}

	public List<Customer> getCustomerMailingList() {

		/*
		 * This method fetches the all customer mailing details and returns it
		 * The students code to fetch data from the database will be written here
		 * Each customer record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		
		List<Customer> customers = new ArrayList<Customer>();
		String query = ""
				+ "SELECT P.SSN, FirstName, LastName, Street, City, State, "
				+ "Zipcode, Email, Telephone, Rating, CardNumber "
				+ "FROM Person P, User U, Account A "
				+ "WHERE P.SSN = A.OwnerSSN AND P.SSN = U.SSN";
		ResultSet r = executeSelectQuery(query);
		
		if (r == null) {
			return null;
		}
		
		try {
			while (r.next()) {
				Customer customer = new Customer();
				customer.setUserID(r.getString("SSN"));
				customer.setFirstName(r.getString("FirstName"));
				customer.setLastName(r.getString("LastName"));
				customer.setAddress(r.getString("Street"));
				customer.setCity(r.getString("City"));
				customer.setState(r.getString("State"));
				customer.setZipCode(r.getInt("Zipcode"));
				customer.setEmail(r.getString("Email"));
				customer.setTelephone(r.getString("Telephone"));
				customer.setCreditCard(r.getString("CardNumber"));
				customer.setRating(r.getInt("Rating"));
				customers.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
		return customers;
	}

	public Customer getCustomer(String customerID) {

		/*
		 * This method fetches the customer details and returns it
		 * customerID, which is the Customer's ID who's details have to be fetched, is given as method parameter
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */
		
		String query = ""
				+ "SELECT P.SSN, FirstName, LastName, Street, City, State, Zipcode, Telephone, "
				+ "Email, AcctNum, AcctCreateDate, PPP, DateOfLastAct, CardNumber, Rating, Password "
				+ "FROM Person P, Account A, User U "
				+ "WHERE P.SSN = A.OwnerSSN AND P.SSN = U.SSN "
				+ "AND U.SSN = ?";
		
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customerID);
			
			ResultSet r = ps.executeQuery();
			if (r == null || !r.next()) {
				return null;
			}
			
			Customer customer = new Customer();
			customer.setUserID(r.getString("SSN"));
			customer.setUserSSN(r.getString("SSN"));
			customer.setFirstName(r.getString("FirstName"));
			customer.setLastName(r.getString("LastName"));
			customer.setAddress(r.getString("Street"));
			customer.setCity(r.getString("City"));
			customer.setState(r.getString("State"));
			customer.setZipCode(r.getInt("Zipcode"));
			customer.setTelephone(r.getString("Telephone"));
			customer.setEmail(r.getString("Email"));
			customer.setAccNum(r.getString("AcctNum"));
			customer.setAccCreateDate(r.getString("AcctCreateDate"));
			customer.setPpp(r.getString("PPP"));
			customer.setDateLastActive(r.getString("DateOfLastAct"));
			customer.setCreditCard(r.getString("CardNumber"));
			customer.setRating(r.getInt("Rating"));
			customer.setPassword(r.getString("Password"));
			return customer;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String deleteCustomer(String customerID) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * customerID, which is the Customer's ID who's details have to be deleted, is given as method parameter
		 */

		/*Sample data begins*/
		return "success";
		/*Sample data ends*/
		
	}


	public String getCustomerID(String username) {
		/*
		 * This method returns the Customer's ID based on the provided email address
		 * The students code to fetch data from the database will be written here
		 * username, which is the email address of the customer, who's ID has to be returned, is given as method parameter
		 * The Customer's ID is required to be returned as a String
		 */

		return "111-11-1111";
	}


	public String addCustomer(Customer customer) {

		/*
		 * All the values of the add customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the customer details and return "success" or "failure" based on result of the database insertion.
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	public String editCustomer(Customer customer) {
		/*
		 * All the values of the edit customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}


	/**
	 * TODO add "Customer Activation Rate" whatever that means...
	 */
	public List<Customer>  getMostActiveUser(){
		List<Customer> customers = new ArrayList<Customer>();
		
		String query = ""
				+ "SELECT SSN "
				+ "FROM User "
				+ "ORDER BY DateOfLastAct Desc "
				+ "LIMIT 5";
		ResultSet r = executeSelectQuery(query);
		
		if (r == null) {
			return null;
		}
		
		try {
			while (r.next()) {
				Customer customer = new Customer();
				customer.setUserSSN(r.getString("SSN"));
				customers.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return customers;
	}

	public List<Customer> getDatedCustomers(String customerID){

		List<Customer> customers = new ArrayList<Customer>();
		
		String query = ""
				+ "SELECT F.OwnerSSN AS SSN, Pe.FirstName, Pe.LastName "
				+ "FROM ("
				+ "SELECT D.Profile1, D.Profile2 "
				+ "FROM Date D, Profile P "
				+ "WHERE P.OwnerSSN=? AND (P.ProfileID=D.Profile1 OR P.ProfileID=D.Profile2) "
				+ ") result, Profile F, Person Pe "
				+ "WHERE NOT(F.OwnerSSN=?) "
				+ "AND (F.ProfileID=result.Profile1 OR F.ProfileID=result.Profile2) "
				+ "AND Pe.SSN = F.OwnerSSN";
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customerID);
			ps.setString(2, customerID);
			System.out.println(ps);
			
			ResultSet r = ps.executeQuery();
			
			while (r.next()) {
				Customer customer = new Customer();
				customer.setUserSSN(r.getString("SSN"));
				customer.setFirstName(r.getString("FirstName"));
				customer.setLastName(r.getString("LastName"));
				customers.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return customers;
	}

	public List<Customer> getHighestRatedCustomer(){
		List<Customer> customers = new ArrayList<Customer>();

		String query = ""
				+ "SELECT SSN, Rating "
				+ "FROM User "
				+ "ORDER BY Rating Desc "
				+ "LIMIT 5";
		ResultSet r = executeSelectQuery(query);
		
		if (r == null) {
			return null;
		}
		
		try {
			while (r.next()) {
				Customer customer = new Customer();
				customer.setUserSSN(r.getString("SSN"));
				customer.setRating(r.getInt("rating"));
				customers.add(customer);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return customers;
	}


	public List<Customer> getDateSuggestions(String userID) {
		/*
		 * This method fetches one or more customers and returns it as an ArrayList
		 */

		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setUserID("111-11-1111");
			customer.setFirstName("long");
			customer.setLastName("Lu");
			customer.setAddress("123 Success Street12");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setZipCode(11790);
			customer.setTelephone("5166328959");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setAccNum("12345");
			customer.setAccCreateDate("12-12-2020");
			customer.setCreditCard("1234567812345678");
			customer.setPpp("User");
			customer.setRating(1);
			customer.setDateLastActive("12-12-2020");
			customers.add(customer);
		}
		/*Sample data ends*/

		return customers;
	}
	
	private ResultSet executeSelectQuery(String query) {
		
		try {
    		Class.forName(JDBC_DRIVER);
    		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    		Statement st = con.createStatement();
    		
    		ResultSet rs = st.executeQuery(query);
    		return rs;
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
	}
	


}
