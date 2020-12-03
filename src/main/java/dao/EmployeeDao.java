package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;

public class EmployeeDao {
	/*
	 * This class handles all the database operations related to the employee table
	 */
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";
	
	public String addEmployee(Employee employee) {

		/*
		 * All the values of the add employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the employee details and return "success" or "failure" based on result of the database insertion.
		 */
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO Employee (SSN, Role, StartDate, HourlyRate) VALUES (?, ?, ?, ?);");
			
			pstmt.setString(1, employee.getEmployeeID());
			pstmt.setString(2, employee.getEmployeeRole());
			pstmt.setDate(3, Date.valueOf(employee.getStartDate()));
			pstmt.setFloat(4, employee.getHourlyRate());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		
		return "success";
	}

	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE Employee "
				  + "SET Role=?, "
				  +     "StartDate=?, "
				  + 	"HourlyRate=? "
				  + "WHERE SSN=?;");
			
			pstmt.setString(1, employee.getEmployeeRole());
			pstmt.setDate(2, Date.valueOf(employee.getStartDate()));
			pstmt.setFloat(3, employee.getHourlyRate());
			pstmt.setString(4, employee.getEmployeeID());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
		
		return "success";

	}

	public String deleteEmployee(String employeeID) {
		/*
		 * employeeID, which is the Employee's ID which has to be deleted, is given as method parameter
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		
		PersonDao personDao = new PersonDao();
		String result = personDao.deletePerson(employeeID);
		return result;

	}

	
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to return details about all the employees must be implemented
		 * Each record is required to be encapsulated as a "Employee" class object and added to the "employees" List
		 */
		
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			
			Statement st = con.createStatement();
			String getEmployees = "SELECT SSN "
								+ "FROM Employee;";
			
			ResultSet rs = st.executeQuery(getEmployees);
			while (rs.next()) {
				String ssn = rs.getString("SSN");
				Employee employee = getEmployee(ssn);
				employees.add(employee);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return employees;
	}

	public Employee getEmployee(String employeeID) {

		/*
		 * The students code to fetch data from the database based on "employeeID" will be written here
		 * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */

		Employee employee = new Employee();
		
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			
			Statement st = con.createStatement();
			String getEmployee = "SELECT P.*, E.Role, E.StartDate, E.HourlyRate "
							+    "FROM Person P, Employee E "
							+    "WHERE P.SSN=E.SSN AND E.SSN='" + employeeID + "';";
			
			ResultSet rs = st.executeQuery(getEmployee);
			
			if (rs.next()) {
				employee.setEmployeeID(employeeID);
				employee.setEmployeeRole(rs.getString("Role"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setLastName(rs.getString("LastName"));
				employee.setAddress(rs.getString("Street"));
				employee.setCity(rs.getString("City"));
				employee.setState(rs.getString("State"));
				employee.setZipCode(rs.getInt("Zipcode"));
				employee.setTelephone(rs.getString("Telephone"));
				employee.setEmail(rs.getString("Email"));
				employee.setStartDate(rs.getDate("StartDate").toString());
				employee.setHourlyRate(rs.getFloat("HourlyRate"));
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		return employee;
	}
	
	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username" will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID is required to be returned as a String
		 */
		String result = "";
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			
			Statement st = con.createStatement();
			String getEmployeeID = "SELECT E.SSN "
								+  "FROM Person P, Employee E "
								+  "WHERE P.SSN=E.SSN AND P.Email='" + username + "';";
			
			ResultSet rs = st.executeQuery(getEmployeeID);
			if (rs.next()) { 
				result = rs.getString("SSN");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
