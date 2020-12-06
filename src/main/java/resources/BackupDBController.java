package resources;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BackupDBController
 */
public class BackupDBController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackupDBController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String dbName = request.getParameter("dbname");
		String dbUsername = request.getParameter("dbuser");
		String dbPassword = request.getParameter("dbpassword");
		String filename = request.getParameter("backupName");
		String result = "";

		boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			if(isWindows) {
				processBuilder.command("cmd.exe", 
						"/c", 
						"mysqldump -u " + dbUsername + " -p" + dbPassword + " --databases " + dbName + " > C:\\" + filename +".sql");
			}
			else {
				// TODO write in docs to HIGHLY recommend using a unix machine
				processBuilder.command("sh", 
						"-c", 
						"/usr/local/mysql/bin/mysqldump -u " + dbUsername + " -p" + dbPassword + " --databases " + dbName + " > ~/" + filename +".sql");
			}
			Process proc = processBuilder.start();
			int exitVal = proc.waitFor();
			if(exitVal == 0) {
				result = "Success";
			} else {
				result = "Failed";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("confirmBackupDB.jsp");
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