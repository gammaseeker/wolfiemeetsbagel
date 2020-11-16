package dao;

public class ReferralDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	public String referProfile(String profileA, String profileB, String profileC){

		return profileA +" has referred " + profileB + "  to " + profileC;
	}
}
