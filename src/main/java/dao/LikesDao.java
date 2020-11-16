package dao;

import model.Profile;

import java.util.ArrayList;
import java.util.List;

public class LikesDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	public String setNewLike(String user1, String user2){
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
