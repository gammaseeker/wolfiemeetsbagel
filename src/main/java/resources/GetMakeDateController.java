package resources;

import dao.DateDao;
import dao.EmployeeDao;
import model.Date;
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
 * Servlet implementation class GetEmployeesController
 */
public class GetMakeDateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMakeDateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user1 = request.getParameter("from");
		String user2 = request.getParameter("to");
		String dateTime = request.getParameter("date");
		String location = request.getParameter("Location");

		System.out.println("From = "+user1+" to = "+user2);

		DateDao dao = new DateDao();
		String result = dao.setNewDate(user1,user2, dateTime, location);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("confirmNewDate.jsp");
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
