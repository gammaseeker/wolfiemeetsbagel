package dao;

import model.Profile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class ProfileDao {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";
	static final String[] commonQueryFields = new String[] {
			"ProfileID",
			"CONCAT(FirstName, \' \', LastName) AS Name",
			"CONCAT(Street, \', \', City, \', \', State, \' \', ZipCode) AS Address",
			"Age",
			"M_F",
			"PhyChar",
			"Hobbies",
			"Photo",
			"DatinGeoRange",
			"CONCAT(DatingAgeRangeStart, \' to \', DatingAgeRangeEnd) AS AgeRange"
	};


	/**
	 * @return a list of all profiles in the database
	 */
    public List<Profile> getProfiles() {

        String getProfilesQuery = ""
        		+ "SELECT "
        		+ String.join(", ", commonQueryFields)
        		+ " FROM Profile, Person"
        		+ " WHERE Profile.OwnerSSN = Person.SSN;";

        return getProfilesFromQuery(getProfilesQuery);
    }

    /**
     * @param age to filter by (e.g. 21)
     * @return list of profiles that match the specified age
     */
    public List<Profile> getProfilesByAge(String age) {
    	
    	String getProfilesByAgeQuery = ""
        		+ "SELECT "
        		+ String.join(", ", commonQueryFields)
        		+ " FROM Profile, Person"
        		+ " WHERE Profile.OwnerSSN = Person.SSN"
        		+ " AND Age = " + age + ";";

        return getProfilesFromQuery(getProfilesByAgeQuery);
    }

    /**
     * @param weight to filter by (e.g. "150")
     * @return list of profiles that match the specified weight
     */
    public List<Profile> getProfilesByWeight(String weight) {

    	String getProfilesByWeightQuery = ""
        		+ "SELECT "
        		+ String.join(", ", commonQueryFields)
        		+ " FROM Profile, Person"
        		+ " WHERE Profile.OwnerSSN = Person.SSN"
        		+ " AND Weight = " + weight + ";";

        return getProfilesFromQuery(getProfilesByWeightQuery);
    }

    /**
     * @param height to filter by (e.g. "6")
     * @return list of profiles that match the specified height
     */
    public List<Profile> getProfilesByHeight(String height) {

    	String getProfilesByHeightQuery = ""
        		+ "SELECT "
        		+ String.join(", ", commonQueryFields)
        		+ " FROM Profile, Person"
        		+ " WHERE Profile.OwnerSSN = Person.SSN"
        		+ " AND Height = " + height + ";";

        return getProfilesFromQuery(getProfilesByHeightQuery);
    }

    /**
     * @param hairColor Hair color to filter by (e.g. "Blonde")
     * @return list of profiles that match the specified hair color
     */
    public List<Profile> getProfilesByHairColor(String hairColor) {

    	String getProfilesByHairColorQuery = ""
        		+ "SELECT "
        		+ String.join(", ", commonQueryFields)
        		+ " FROM Profile, Person"
        		+ " WHERE Profile.OwnerSSN = Person.SSN"
        		+ " AND HairColor = \'" + hairColor + "\';";

        return getProfilesFromQuery(getProfilesByHairColorQuery);
    }
    
    /**
     * 
     * @param query the Select query returning some subset of profiles.
     * Query must contain all of the common query fields
     * @return List of profiles returned by the query
     */
    private List<Profile> getProfilesFromQuery(String query) {
    	
    	List<Profile> profiles = new ArrayList<Profile>();
    	try {
    		Class.forName(JDBC_DRIVER);
    		Connection con = DriverManager.getConnection(DB_URL, "root", "root");
    		Statement st = con.createStatement();
    		
    		ResultSet rs = st.executeQuery(query);
    		while (rs.next()) {
    			Profile profile = new Profile();
    			profile.setProfileID(rs.getString("ProfileID"));
    			profile.setProfileName(rs.getString("Name"));
    			profile.setAge(rs.getString("Age"));
    			profile.setAddress(rs.getString("Address"));
    			profile.setGender(rs.getString("M_F"));
    			profile.setPhy_char(rs.getString("PhyChar"));
    			profile.setInterests(rs.getString("Hobbies"));
    			profile.setPhoto(rs.getString("Photo"));
    			profile.setGeoRange(rs.getString("DatinGeoRange"));
    			profile.setAgeRange(rs.getString("AgeRange"));
    			profiles.add(profile);
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    	
    	return profiles;
    }

}
