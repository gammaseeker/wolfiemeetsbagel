package resources;

import dao.CustomerDao;
import dao.DateDao;
import dao.LikesDao;
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
import java.util.List;

/**
 * Servlet implementation class GetDatesByCalendarDateController
 */
public class GetFavoritesListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFavoritesListController() {
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

//		String searchKeyword = request.getParameter("customerName");

        LikesDao dao = new LikesDao();

        List<String> users = dao.getFavorites("Vikram");

        request.setAttribute("users",users);
        RequestDispatcher rd = request.getRequestDispatcher("showFavorites.jsp");
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
