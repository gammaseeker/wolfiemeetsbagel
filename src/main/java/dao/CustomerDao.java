package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Customer;

import java.util.stream.IntStream;

public class CustomerDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	/**
	 * @return ArrayList<Customer> object
	 */
	public List<Customer> getCustomers() {
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
			customer.setUserSSN("112-11-1111");
			customer.setFirstName("Shiyong");
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

	public List<Customer> getCustomerMailingList() {

		/*
		 * This method fetches the all customer mailing details and returns it
		 * The students code to fetch data from the database will be written here
		 * Each customer record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		
		List<Customer> customers = new ArrayList<Customer>();
		
		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setUserID("111-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Shiyong");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setZipCode(11790);
			customers.add(customer);			
		}
		/*Sample data ends*/
		
		return customers;
	}

	public Customer getCustomer(String customerID) {

		/*
		 * This method fetches the customer details and returns it
		 * customerID, which is the Customer's ID who's details have to be fetched, is given as method parameter
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */
		
		/*Sample data begins*/
		Customer customer = new Customer();
		customer.setUserID("111-11-1111");
		customer.setAddress("123 Success Street");
		customer.setLastName("Lu");
		customer.setFirstName("Shiyong");
		customer.setCity("Stony Brook");
		customer.setState("NY");
		customer.setEmail("shiyong@cs.sunysb.edu");
		customer.setZipCode(11790);
		customer.setTelephone("5166328959");
		customer.setCreditCard("1234567812345678");
		customer.setRating(1);
		/*Sample data ends*/
		
		return customer;
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



	public List<Customer>  getMostActiveUser(){
		List<Customer> customers = new ArrayList<Customer>();

		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setUserID("111-11-1111");
			customer.setUserSSN("112-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Upendra Nath Chaurasia");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("uppu_chaur@cs.sunysb.edu");
			customer.setZipCode(11790);
			customers.add(customer);
		}
		/*Sample data ends*/

		return customers;
	}

	public List<Customer> getDatedCustomers(String primary){

		List<Customer> customers = new ArrayList<Customer>();

		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setUserID("111-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Upendra Nath Chaurasia");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("uppu_chaur@cs.sunysb.edu");
			customer.setZipCode(11790);
			customers.add(customer);
		}
		/*Sample data ends*/

		return customers;
	}

	public List<Customer> getHighestRatedCustomer(){
		List<Customer> customers = new ArrayList<Customer>();

		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setUserID("111-11-1111");
			customer.setUserSSN("112-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Upendra Nath Chaurasia");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("uppu_chaur@cs.sunysb.edu");
			customer.setZipCode(11790);
			customers.add(customer);
		}
		/*Sample data ends*/

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


}
