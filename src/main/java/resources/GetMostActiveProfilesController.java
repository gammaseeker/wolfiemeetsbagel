package resources;

import dao.CustomerDao;
import dao.DateDao;
import dao.ProfileDao;
import model.Customer;
import model.Date;
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
 * Servlet implementation class GetDatesByCalendarDateController
 */
public class GetMostActiveProfilesController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMostActiveProfilesController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	ProfileDao pd = new ProfileDao();
        List<Profile> mostActiveProfiles = pd.getMostActiveProfiles();

        request.setAttribute("profiles",mostActiveProfiles);
        RequestDispatcher rd = request.getRequestDispatcher("showMostActiveProfile.jsp");
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
