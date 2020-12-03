package resources;

import dao.CustomerDao;
import dao.DateDao;
import dao.ProfileDao;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Servlet implementation class GetDatesByCalendarDateController
 */
public class GetPopularGeoLocationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPopularGeoLocationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * This method retrieves the most popular date locations
         * A 'popular date location' is determined by 
         * counting the frequency of how many times a location has been used for a date
         * The results are in descending order (most popular to least popular)
         */

    	DateDao date = new DateDao();
    	LinkedHashMap<String, Integer> popular = date.getMostPopularLocations();

        request.setAttribute("locations", popular);
        //request.setAttribute("frequency", popular);

        RequestDispatcher rd = request.getRequestDispatcher("showMostPopularLocation.jsp");
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
