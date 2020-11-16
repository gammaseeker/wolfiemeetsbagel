package resources;


import dao.CustomerDao;
import dao.ProfileDao;
import model.Customer;
import model.Profile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class GetCustomersController
 */
public class GetProfilesListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProfilesListController() {
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
		
//		String searchKeyword = request.getParameter("searchKeyword");
		ProfileDao dao = new ProfileDao();
		List<Profile> profiles = dao.getProfiles();

		request.setAttribute("profiles", profiles);
		RequestDispatcher rd = request.getRequestDispatcher("showProfilesList.jsp");
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
