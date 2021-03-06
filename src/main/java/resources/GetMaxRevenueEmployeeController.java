package resources;

import dao.EmployeeDao;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class GetDatesByCalendarDateController
 */
public class GetMaxRevenueEmployeeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMaxRevenueEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         *
         * This data is sent to the getCustomers method in the dao.CustomerDao class
         * The data received from the getCustomers method is sent to the Customer Listing page as request attribute "customers"
         * This method redirects to the Customer Listing page
         */

        // This is just a sample. Use your own logic to get data from apt daos.

    	EmployeeDao employeeDao = new EmployeeDao();
		Employee resultEmployee = employeeDao.getEmployeeWithMaxRevenue();

		if(resultEmployee != null) {
	        request.setAttribute("employees", resultEmployee.getFirstName() + ' ' + resultEmployee.getLastName());
	        request.setAttribute("revenue", resultEmployee.getRevenue());
		} else {
			request.setAttribute("employees", "None");
	        request.setAttribute("revenue", "0");
		}

        RequestDispatcher rd = request.getRequestDispatcher("showMaxRevenueByEmployee.jsp");
        rd.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
