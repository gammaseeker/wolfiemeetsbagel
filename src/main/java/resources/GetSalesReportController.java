package resources;

import dao.DateDao;
import model.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class GetSalesReportController
 */
public class GetSalesReportController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSalesReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String year = request.getParameter("year");
        String month = request.getParameter("month");

        DateDao dao = new DateDao();
        
        int income = -9999; // Default value that denotes error if we cannot compute income (DB fails etc.)

        if(!dao.getSalesReport(month, year).equals("")) {
        	income = Integer.parseInt(dao.getSalesReport(month, year));
        }

        List<Date> openDatesOfThisMonthYear = dao.getDatesByMonthYear(month, year);

        if(income == -9999) {
        	request.setAttribute("income", "Error computing income");
        } else {
			request.setAttribute("income", income);
        }
        request.setAttribute("dates", openDatesOfThisMonthYear);
        request.setAttribute("year", year);
        request.setAttribute("month", month);
        RequestDispatcher rd = request.getRequestDispatcher("showSalesReport.jsp");
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
