package resources;

import dao.ReferralDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class GetEmployeesController
 */
public class GetReferProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReferProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String profileA = request.getParameter("profileA");
		String profileB = request.getParameter("profileB");
		String profileC = request.getParameter("profileC");

		System.out.println("profileA = "+profileA+" profileB = "+profileB+" profileC = " + profileC);

		ReferralDao dao = new ReferralDao();
		String result = dao.referProfile(profileA, profileB, profileC);

		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("confirmMessage.jsp");
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
