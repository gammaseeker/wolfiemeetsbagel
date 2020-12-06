package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Customer;
import model.Person;
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
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement ps = con.prepareStatement("DELETE FROM User WHERE SSN=?");
			ps.setString(1, customerID);
			ps.executeUpdate();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}


	public String getCustomerID(String email) {
		
		String query = ""
				+ "SELECT SSN FROM Person WHERE Email=?";
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet r = ps.executeQuery();
			if (r == null || !r.next()) {
				return null;
			}
			
			return r.getString("SSN");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	public String addCustomer(Customer customer) {

		/*
		 * All the values of the add customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the customer details and return "success" or "failure" based on result of the database insertion.
		 */
		PersonDao pd = new PersonDao();
		if (pd.addPerson(new Person(customer)) == "failure") {
			return "failure";
		};
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			PreparedStatement insertUser = con.prepareStatement(
				"INSERT INTO User VALUES (?,?,?,?)"
			);
			
			insertUser.setString(1, customer.getUserID());
			insertUser.setString(2, customer.getPpp());
			insertUser.setInt(3, customer.getRating());
			insertUser.setString(4, customer.getDateLastActive());
			
			int userRowsInserted = insertUser.executeUpdate();
			if (userRowsInserted == 0) {
				return "failure";
			}
			
			PreparedStatement insertAccount = con.prepareStatement(
				"INSERT INTO Account VALUES (?,?,?,?)"
			);
			
			insertAccount.setString(1, customer.getUserID());
			insertAccount.setString(2, customer.getCreditCard());
			insertAccount.setString(3, customer.getAccNum());
			insertAccount.setString(4, customer.getAccCreateDate());
			
			int accountRowsInserted = insertAccount.executeUpdate();
			if (accountRowsInserted == 0) {
				return "failure";
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		return "success";

	}

	public String editCustomer(Customer customer) {
		
		PersonDao pd = new PersonDao();
		if (pd.editPerson(new Person(customer)) == "failure") {
			return "failure";
		};
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			PreparedStatement updateUser = con.prepareStatement(
					"UPDATE User "
				  + "SET PPP=?, "
				  +     "Rating=?, "
				  + 	"DateOfLastAct=? "
				  + "WHERE SSN=?;");
			
			updateUser.setString(1, customer.getPpp());
			updateUser.setInt(2, customer.getRating());
			updateUser.setString(3, customer.getDateLastActive());
			updateUser.setString(4, customer.getUserID());
			int userRowsUpdated = updateUser.executeUpdate();
			if (userRowsUpdated == 0) {
				return "failure";
			}
			
			PreparedStatement updateAccount = con.prepareStatement(
					"UPDATE Account "
				  + "SET CardNumber=?, "
				  +     "AcctNum=?, "
				  + 	"AcctCreateDate=? "
				  + "WHERE OwnerSSN=?;");
			
			updateAccount.setString(1, customer.getCreditCard());
			updateAccount.setString(2, customer.getAccNum());
			updateAccount.setString(3, customer.getAccCreateDate());
			updateAccount.setString(4, customer.getUserID());
			int accountRowsUpdated = updateAccount.executeUpdate();
			if (accountRowsUpdated == 0) {
				return "failure";
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		return "success";

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
		List<Customer> customers = new ArrayList<Customer>();
		
		String query = ""
				+ "SELECT DISTINCT P.SSN, FirstName, LastName, Street, City, State, "
				+ "Zipcode, Email, Telephone, Rating, CardNumber "
				+ "FROM ("
					+ "SELECT P2.OwnerSSN AS MatchingProfileSSN "
					+ "FROM Profile P1, Profile P2 "
					+ "WHERE "
					+ "((P1.M_F = \"MALE\" AND P2.M_F = \"FEMALE\" AND P1.Height > P2.Height AND P1.Weight > P2.Weight) "
					+ "OR  (P1.M_F = \"FEMALE\" AND P2.M_F = \"MALE\" AND P1.Height < P2.Height AND P1.Weight < P2.Weight)) "
					+ "AND P1.OwnerSSN = ?"
				+ ") Result, Person P, User U, Account A "
				+ "WHERE Result.MatchingProfileSSN = P.SSN "
				+ "AND P.SSN = U.SSN "
				+ "AND P.SSN = A.OwnerSSN";
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, userID);
			
			ResultSet r = ps.executeQuery();
			
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
	
	public HashMap<Integer, String> getCustomerWithMaxRevenue() {
		HashMap<Integer, String> result = new HashMap<Integer, String>();
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			
			Statement st = con.createStatement();
			String getCustomerWithMaxRevenue = "SELECT Profile1, SUM(BookingFee) AS Revenue "
											+  "FROM Date "
											+  "GROUP BY Profile1 "
											+  "ORDER BY SUM(BookingFee) DESC "
											+  "LIMIT 1;";
			
			ResultSet rs = st.executeQuery(getCustomerWithMaxRevenue);
			int revenue = 0;
			String profile1 = "";
			if (rs.next()) {
				profile1 = rs.getString("Profile1");
				revenue = rs.getInt("Revenue");
				Statement st2 = con.createStatement();
				String getCustomerName = "SELECT FirstName, LastName "
									+ "FROM Person "
									+ "INNER JOIN profile ON profile.OwnerSSN=person.SSN "
									+ "WHERE ProfileID=\'" + profile1 + "\';";
				ResultSet rs2 = st2.executeQuery(getCustomerName);
				if(rs2.next()) {
					result.put(revenue, rs2.getString("FirstName") + " " + rs2.getString("LastName"));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return result;
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
