package dao;

import model.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LikesDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";

	public String setNewLike(String user1, String user2){
    	try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			st.execute(""
				+ "INSERT INTO likes VALUES (\'"
				+ user1 + "\', \'" 
				+ user2 + "\', NOW())");
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
    	}
		return "User - "+user1+" likes "+user2;
	}

	public List<String> getFavorites(String mw){

		/*Sample data begins*/
		List<String> favs = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			favs.add("user123");

		/*Sample data ends*/

		return favs;
	}

}
