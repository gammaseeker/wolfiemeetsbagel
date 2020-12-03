package resources;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dao.LoginDao;
import dao.PersonDao;
import model.Employee;
import model.Login;
import model.Person;

/**
 * Servlet implementation class UpdateEmployeeController
 */
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("employeeEmail");
		String firstName = request.getParameter("employeeFirstName");
		String lastName = request.getParameter("employeeLastName");
		String address = request.getParameter("employeeAddress");
		String city = request.getParameter("employeeCity");
		String state= request.getParameter("employeeState");
		String role= request.getParameter("employeeRole");
		int zipcode = Integer.parseInt(request.getParameter("employeeZipcode"));
		String telephone = request.getParameter("employeeTelephone");
		String ssn = request.getParameter("employeeSSN");
		String startDate = request.getParameter("employeeStartDate");
		float hourlyRate = Float.parseFloat(request.getParameter("employeeHourlyRate"));
		
		Person person = new Person();
		person.setPersonID(ssn);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setStreet(address);
		person.setCity(city);
		person.setState(state);
		person.setZipCode(zipcode);
		person.setEmail(email);
		person.setTelephone(telephone);
		
		PersonDao personDao = new PersonDao();
		String resultPerson = personDao.editPerson(person);
		
		Employee employee = new Employee();
		employee.setEmployeeID(ssn);
		employee.setEmployeeRole(role);
		employee.setStartDate(startDate);
		employee.setHourlyRate(hourlyRate);
		
		EmployeeDao employeeDao = new EmployeeDao();
		String resultEmployee = employeeDao.editEmployee(employee);
		
		if(resultPerson.equals("success") && resultEmployee.equals("success")) {
			response.sendRedirect("managerHome.jsp?status=editEmployeeSuccess");
		}
		else {
			response.sendRedirect("editEmployee.jsp?status=error");
		}

	}

}
