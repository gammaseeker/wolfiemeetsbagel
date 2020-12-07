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
import java.util.HashMap;
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


    	CustomerDao customerDao = new CustomerDao();
    	HashMap<Integer, String> resultCustomer = customerDao.getCustomerWithMaxRevenue();
    	int revenue = (int) resultCustomer.keySet().toArray()[0];


        request.setAttribute("customer", resultCustomer.get(revenue));
        request.setAttribute("revenue", revenue);

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
