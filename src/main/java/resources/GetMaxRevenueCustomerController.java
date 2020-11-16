package resources;

import dao.CustomerDao;
import dao.DateDao;
import dao.ProfileDao;
import model.Customer;
import model.Date;

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
public class GetMaxRevenueCustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMaxRevenueCustomerController() {
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

        List<String> customers = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            customers.add("Hardik Pandya");

        request.setAttribute("customers", customers);
        request.setAttribute("revenue", "2000");

        RequestDispatcher rd = request.getRequestDispatcher("showMaxRevenueByCustomer.jsp");
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
