package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import model.Login;

public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";
	
	public Login login(String username, String password) {
		/*
		 * Return a Login object with role as "manager", "customerRepresentative" or "customer" if successful login
		 * Else, return null
		 * The role depends on the type of the user, which has to be handled in the database
		 * username, which is the email address of the user, is given as method parameter
		 * password, which is the password of the user, is given as method parameter
		 * Query to verify the username and password and fetch the role of the user, must be implemented
		 */
		Login login = new Login();
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();
			
			String checkEmplpoyee = "SELECT Role "
								+ 	"FROM Employee "
								+ 	"WHERE SSN=( "
								+ 		"SELECT SSN "
								+ 		"FROM Person "
								+ 		"WHERE Email='" + username + "' AND Password='" + password + "');";
			ResultSet rs1 = st.executeQuery(checkEmplpoyee);
			
			// We have to check if its customer if the username and password does not map to an employee
			if (rs1.next() == false) {
				String checkCustomer = "SELECT SSN "
								   +   "FROM Person "
								   +   "WHERE Email='" + username + "' AND Password='" + password + "';";
				ResultSet rs2 = st.executeQuery(checkCustomer);
				
				if (rs2.next() == false) {
					login = null;
				} else {
					login.setRole("customer");
				}
			} else {
				String role = rs1.getString("Role");
				if (role.equals("Manager")) {
					login.setRole("manager");
				} else {
					login.setRole("customerRepresentative");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return login;
	}
	
	public String addUser(Login login) {
		/*
		 * Query to insert a new record for user login must be implemented
		 * login, which is the "Login" Class object containing username and password for the new user, is given as method parameter
		 * The username and password from login can get accessed using getter methods in the "Login" model
		 * e.g. getUsername() method will return the username encapsulated in login object
		 * Return "success" on successful insertion of a new user
		 * Return "failure" for an unsuccessful database operation
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/
	}

}
