package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ReferralDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";

	public String referProfile(String profileA, String profileB, String profileC){
    	try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			st.execute(""
				+ "INSERT INTO blinddate VALUES (\'"
				+ profileA + "\', \'" 
				+ profileB + "\', \'"
				+ profileC +"\', NOW())");
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
    	}
		return profileA +" has referred " + profileB + "  to " + profileC;
	}
}
