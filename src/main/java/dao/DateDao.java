package dao;

import model.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DateDao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";

    public String addDate(Date date) {
    	try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			st.execute(""
				+ "INSERT INTO date (Profile1, Profile2, CustRep, Date_Time, Location, BookingFee, Comments, User1Rating, User2Rating) "
				+ "VALUES (\'"
				+ date.getUser1ID() + "\', \'" 
				+ date.getUser2ID() + "\', \'"
				+ date.getCustRepresentative() +"\', \'" 
				+ date.getDate() +"\', \'"
				+ date.getGeolocation() +"\', \'"
				+ date.getBookingfee() +"\', \'"
				+ date.getComments() +"\', \'"
				+ date.getUser1Rating() +"\', \'"
				+ date.getUser2Rating() +"\') ");
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
    	}
    	return "success";
    }


    public List<Date> getDatesByCalendar(String calendarDate) {

		List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(""
					+ "SELECT * "
					+ "FROM date "
					+ "WHERE CAST(Date_Time AS DATE) = CAST(\'" + calendarDate + "\' AS DATE)"); 
			while(rs.next()) {
				Statement st2 = con.createStatement();
				ResultSet rsCustRep = st2.executeQuery(""
						+ "SELECT FirstName, LastName "
						+ "FROM Person "
						+ "WHERE SSN=\'" + rs.getString("CustRep") + "\'");
				if(rsCustRep.next()) {
					String profile1 = rs.getString("Profile1");
					String profile2 = rs.getString("Profile2");
					String dateTime = rs.getString("Date_Time");

					Date date = new Date();
					date.setDateID(rs.getString("DateID"));
					date.setUser1ID(profile1);
					date.setUser2ID(profile2);
					date.setDate(dateTime);
					date.setGeolocation(rs.getString("Location"));
					date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
					date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
					date.setComments(rs.getString("Comments"));
					date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
					date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
					dates.add(date);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dates;
    }

    public List<Date> getDatesByMonthYear(String month, String year) {
        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(""
					+ "SELECT * FROM date WHERE MONTH(Date_Time)=\'" + month + "\' AND YEAR(Date_Time)=\'" + year + "\'"); 
			while(rs.next()) {
				Statement st2 = con.createStatement();
				ResultSet rsCustRep = st2.executeQuery(""
						+ "SELECT FirstName, LastName "
						+ "FROM Person "
						+ "WHERE SSN=\'" + rs.getString("CustRep") + "\'");
				if(rsCustRep.next()) {
					String profile1 = rs.getString("Profile1");
					String profile2 = rs.getString("Profile2");
					String dateTime = rs.getString("Date_Time");

					Date date = new Date();
					date.setDateID(rs.getString("DateID"));
					date.setUser1ID(profile1);
					date.setUser2ID(profile2);
					date.setDate(dateTime);
					date.setGeolocation(rs.getString("Location"));
					date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
					date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
					date.setComments(rs.getString("Comments"));
					date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
					date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
					dates.add(date);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dates;
    }

    public List<Date> getDatesByCustomerName(String customerFirstName, String customerLastName) {

        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();
			String innerQuery = 
					"SELECT ProfileID "
					+ "FROM profile "
					+ "INNER JOIN person "
					+ "ON profile.OwnerSSN = person.SSN "
					+ "WHERE person.FirstName = \'"
					+ customerFirstName + "\' "
					+ "AND person.LastName = \'"
					+ customerLastName + "\' ";
			ResultSet rs = st.executeQuery(innerQuery);
			while(rs.next()) {
				String outerQuery = 
						"SELECT * FROM date WHERE Profile1 = (\'" + rs.getString("ProfileID") + "\') OR Profile2 = (\'" + rs.getString("ProfileID") + "\')";
				Statement st2 = con.createStatement();
				ResultSet rsFinal = st2.executeQuery(outerQuery);
				while(rsFinal.next()) {

					Statement st3 = con.createStatement();
					ResultSet rsCustRep = st3.executeQuery(""
							+ "SELECT FirstName, LastName "
							+ "FROM Person "
							+ "WHERE SSN=\'" + rsFinal.getString("CustRep") + "\'");
					if(rsCustRep.next()) {
						String profile1 = rsFinal.getString("Profile1");
						String profile2 = rsFinal.getString("Profile2");
						String dateTime = rsFinal.getString("Date_Time");

						Date date = new Date();
						date.setDateID(rsFinal.getString("DateID"));
						date.setUser1ID(profile1);
						date.setUser2ID(profile2);
						date.setDate(dateTime);
						date.setGeolocation(rsFinal.getString("Location"));
						date.setBookingfee(Integer.toString(rsFinal.getInt("BookingFee")));
						date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
						date.setComments(rsFinal.getString("Comments"));
						date.setUser1Rating(Integer.toString(rsFinal.getInt("User1Rating")));
						date.setUser2Rating(Integer.toString(rsFinal.getInt("User2Rating")));
						dates.add(date);
					}
				}
			}

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dates;
    }

    public List<Date> getHighestRatedCalendarDate(String calendarDate) {

        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(""
					+ "SELECT * "
					+ "FROM date "
					+ "WHERE CAST(Date_Time AS DATE) = CAST(\'" + calendarDate + "\' AS DATE) "
					+ "AND User1Rating >= 3 AND User2Rating >= 3"); 
			while(rs.next()) {

				Statement st2 = con.createStatement();
				ResultSet rsCustRep = st2.executeQuery(""
						+ "SELECT FirstName, LastName "
						+ "FROM Person "
						+ "WHERE SSN=\'" + rs.getString("CustRep") + "\'");
				if(rsCustRep.next()) {

				String profile1 = rs.getString("Profile1");
				String profile2 = rs.getString("Profile2");
				String dateTime = rs.getString("Date_Time");

				Date date = new Date();
				date.setDateID(rs.getString("DateID"));
				date.setUser1ID(profile1);
				date.setUser2ID(profile2);
				date.setDate(dateTime);
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
				date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
				date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
				dates.add(date);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dates;
    }


    public List<Date> getOpenDates(String profileID) {
    	// Open Dates is just the term used in the code base which means all the dates - both past and the pending. - Vibhor
        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			String outerQuery = 
					"SELECT * FROM date WHERE (Profile1 = (\'" + profileID + "\') OR Profile2 = (\'" + profileID + "\'))";
			Statement st = con.createStatement();
			ResultSet rsFinal = st.executeQuery(outerQuery);
			while(rsFinal.next()) {
				Statement st2 = con.createStatement();
				ResultSet rsCustRep = st2.executeQuery(""
						+ "SELECT FirstName, LastName "
						+ "FROM Person "
						+ "WHERE SSN=\'" + rsFinal.getString("CustRep") + "\'");
				if(rsCustRep.next()) {
					String profile1 = rsFinal.getString("Profile1");
					String profile2 = rsFinal.getString("Profile2");
					String dateTime = rsFinal.getString("Date_Time");

					Date date = new Date();
					date.setDateID(rsFinal.getString("DateID"));
					date.setUser1ID(profile1);
					date.setUser2ID(profile2);
					date.setDate(dateTime);
					date.setGeolocation(rsFinal.getString("Location"));
					date.setBookingfee(Integer.toString(rsFinal.getInt("BookingFee")));
					date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
					date.setComments(rsFinal.getString("Comments"));
					date.setUser1Rating(Integer.toString(rsFinal.getInt("User1Rating")));
					date.setUser2Rating(Integer.toString(rsFinal.getInt("User2Rating")));
					dates.add(date);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return dates;
    }

    public String setNewDate(String user1, String user2, String dateTime, String location) {
    	try {
    		int user1Rating = -1;
    		int user2Rating = -1;

			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(""
					+ "SELECT Rating "
					+ "FROM user "
					+ "WHERE SSN = "
					+ "(SELECT OwnerSSN "
					+ "FROM profile "
					+ "WHERE ProfileID = \'" + user1 + "\')");
			if(rs.next()) {
				user1Rating = rs.getInt("Rating");
			}

			rs = st.executeQuery(""
					+ "SELECT Rating "
					+ "FROM user "
					+ "WHERE SSN = "
					+ "(SELECT OwnerSSN "
					+ "FROM profile "
					+ "WHERE ProfileID = \'" + user2 + "\')");
			if(rs.next()) {
				user2Rating = rs.getInt("Rating");
			}
			Statement st2 = con.createStatement();
			st2.execute(""
					+ "INSERT INTO date (Profile1, Profile2, Date_Time, Location, User1Rating, User2Rating) VALUES (\'"
					+ user1 + "\', \'"
					+ user2 + "\', \'"
					+ dateTime + "\', \'"
				    + location + "\', \'"
				    + user1Rating + "\', \'"
				    + user2Rating + "\')");
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
    	}
        return "Successfull date b/w " + user1 + " and " + user2;
    }

    public String cancelDate(String dateID) {
    	try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			st.execute(""
				+ "DELETE FROM date " 
				+ "WHERE DateID=\'"
				+ dateID + "\'");
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
    	}
        return "Date " + dateID + " is now cancelled";
    }

    public String commentDate(String dateID, String comment) {
    	try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			st.execute(""
				+ "UPDATE date " 
				+ "SET Comments=\'"
				+ comment + "\'"
				+ "WHERE DateID=\'" + dateID + "\'");
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
    	}
        return "Date - " + dateID + " has new comment - " + comment;
    }

    public String getSalesReport(String month, String year) {
    	String income = "";
        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(""
					+ "SELECT * FROM date WHERE MONTH(Date_Time)=\'" + month + "\' AND YEAR(Date_Time)=\'" + year + "\'"); 
			while(rs.next()) {
				Statement st2 = con.createStatement();
				ResultSet rsCustRep = st2.executeQuery(""
						+ "SELECT FirstName, LastName "
						+ "FROM Person "
						+ "WHERE SSN=\'" + rs.getString("CustRep") + "\'");
				if(rsCustRep.next()) {
					String profile1 = rs.getString("Profile1");
					String profile2 = rs.getString("Profile2");
					String dateTime = rs.getString("Date_Time");

					Date date = new Date();
					date.setDateID(rs.getString("DateID"));
					date.setUser1ID(profile1);
					date.setUser2ID(profile2);
					date.setDate(dateTime);
					date.setGeolocation(rs.getString("Location"));
					date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
					date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
					date.setComments(rs.getString("Comments"));
					date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
					date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
					dates.add(date);
				}
			}
			rs = st.executeQuery(""
					+ "SELECT SUM(BookingFee) as sum_income FROM date WHERE MONTH(Date_Time)=\'" + month + "\' AND YEAR(Date_Time)=\'" + year + "\' ");
			if(rs.next()) {
				income = Integer.toString(rs.getInt("sum_income"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return income;
    }

    public List<Date> getPendingDates(String profileID) {

        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			String outerQuery = 
					"SELECT * FROM date WHERE Date_Time > NOW() AND (Profile1 = (\'" + profileID + "\') OR Profile2 = (\'" + profileID + "\'))";
			Statement st = con.createStatement();
			ResultSet rsFinal = st.executeQuery(outerQuery);
			while(rsFinal.next()) {
				Statement st2 = con.createStatement();
				ResultSet rsCustRep = st2.executeQuery(""
						+ "SELECT FirstName, LastName "
						+ "FROM Person "
						+ "WHERE SSN=\'" + rsFinal.getString("CustRep") + "\'");
				if(rsCustRep.next()) {
					String profile1 = rsFinal.getString("Profile1");
					String profile2 = rsFinal.getString("Profile2");
					String dateTime = rsFinal.getString("Date_Time");

					Date date = new Date();
					date.setDateID(rsFinal.getString("DateID"));
					date.setUser1ID(profile1);
					date.setUser2ID(profile2);
					date.setDate(dateTime);
					date.setGeolocation(rsFinal.getString("Location"));
					date.setBookingfee(Integer.toString(rsFinal.getInt("BookingFee")));
					date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
					date.setComments(rsFinal.getString("Comments"));
					date.setUser1Rating(Integer.toString(rsFinal.getInt("User1Rating")));
					date.setUser2Rating(Integer.toString(rsFinal.getInt("User2Rating")));
					dates.add(date);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dates;
    }

    public List<Date> getPastDates(String profileID) {

        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			String outerQuery = 
					"SELECT * FROM date WHERE Date_Time < NOW() AND (Profile1 = (\'" + profileID + "\') OR Profile2 = (\'" + profileID + "\'))";
			Statement st = con.createStatement();
			ResultSet rsFinal = st.executeQuery(outerQuery);
			while(rsFinal.next()) {
				Statement st2 = con.createStatement();
				ResultSet rsCustRep = st2.executeQuery(""
						+ "SELECT FirstName, LastName "
						+ "FROM Person "
						+ "WHERE SSN=\'" + rsFinal.getString("CustRep") + "\'");
				if(rsCustRep.next()) {
					String profile1 = rsFinal.getString("Profile1");
					String profile2 = rsFinal.getString("Profile2");
					String dateTime = rsFinal.getString("Date_Time");

					Date date = new Date();
					date.setDateID(rsFinal.getString("DateID"));
					date.setUser1ID(profile1);
					date.setUser2ID(profile2);
					date.setDate(dateTime);
					date.setGeolocation(rsFinal.getString("Location"));
					date.setBookingfee(Integer.toString(rsFinal.getInt("BookingFee")));
					date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
					date.setComments(rsFinal.getString("Comments"));
					date.setUser1Rating(Integer.toString(rsFinal.getInt("User1Rating")));
					date.setUser2Rating(Integer.toString(rsFinal.getInt("User2Rating")));
					dates.add(date);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dates;
    }


    public LinkedHashMap<String, Integer> getMostPopularLocations() {
    	// Key is location, value is frequency
    	LinkedHashMap<String, Integer> locations = new LinkedHashMap<String, Integer>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(""
					+ "SELECT Location, COUNT(DateID) as freq "
					+ "FROM date "
					+ "GROUP BY Location "
					+ "ORDER BY COUNT(DateID) DESC");
			while(rs.next()) {
				locations.put(rs.getString("Location"), rs.getInt("freq"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return locations;
    }


    public List<Date> getDateSuggestions(String user) {

        List<Date> dates = new ArrayList<Date>();

        /*Sample data begins*/
        for (int i = 0; i < 10; i++) {
            Date date = new Date();
            date.setDateID("12313123");
            date.setUser1ID("1212");
            date.setUser2ID("2121");
            date.setDate("12-12-2020");
            date.setGeolocation("location");
            date.setBookingfee("21");
            date.setCustRepresentative("Manoj Pandey");
            date.setComments("Comments");
            date.setUser1Rating("3");
            date.setUser2Rating("3");
            dates.add(date);
        }
        /*Sample data ends*/

        return dates;
    }

    public List<Date> getRevenueByCalendar(String calendarDate) {
        List<Date> dates = new ArrayList<Date>();
        
        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(""
					+ "SELECT * FROM date WHERE CAST(Date_Time AS DATE) = CAST(\'" + calendarDate + "\' AS DATE)"); 
			while(rs.next()) {
				Statement st2 = con.createStatement();
				ResultSet rsCustRep = st2.executeQuery(""
						+ "SELECT FirstName, LastName "
						+ "FROM Person "
						+ "WHERE SSN=\'" + rs.getString("CustRep") + "\'");
				if(rsCustRep.next()) {
					String profile1 = rs.getString("Profile1");
					String profile2 = rs.getString("Profile2");
					String dateTime = rs.getString("Date_Time");

					Date date = new Date();
					date.setDateID(rs.getString("DateID"));
					date.setUser1ID(profile1);
					date.setUser2ID(profile2);
					date.setDate(dateTime);
					date.setGeolocation(rs.getString("Location"));
					date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
					date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
					date.setComments(rs.getString("Comments"));
					date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
					date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
					dates.add(date);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return dates;
    }

    public List<Date> getRevenueByCustomerName(String customerFirstName, String customerLastName) {

        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();
			String innerQuery = 
					"SELECT ProfileID "
					+ "FROM profile "
					+ "INNER JOIN person "
					+ "ON profile.OwnerSSN = person.SSN "
					+ "WHERE person.FirstName = \'"
					+ customerFirstName + "\' "
					+ "AND person.LastName = \'"
					+ customerLastName + "\' ";
			ResultSet rs = st.executeQuery(innerQuery);
			while(rs.next()) {
				String outerQuery = 
						"SELECT * FROM date WHERE Profile1 = (\'" + rs.getString("ProfileID") + "\') OR Profile2 = (\'" + rs.getString("ProfileID") + "\')";
				Statement st2 = con.createStatement();
				ResultSet rsFinal = st2.executeQuery(outerQuery);
				while(rsFinal.next()) {

					Statement st3 = con.createStatement();
					ResultSet rsCustRep = st3.executeQuery(""
							+ "SELECT FirstName, LastName "
							+ "FROM Person "
							+ "WHERE SSN=\'" + rsFinal.getString("CustRep") + "\'");
					if(rsCustRep.next()) {
						String profile1 = rsFinal.getString("Profile1");
						String profile2 = rsFinal.getString("Profile2");
						String dateTime = rsFinal.getString("Date_Time");

						Date date = new Date();
						date.setDateID(rsFinal.getString("DateID"));
						date.setUser1ID(profile1);
						date.setUser2ID(profile2);
						date.setDate(dateTime);
						date.setGeolocation(rsFinal.getString("Location"));
						date.setBookingfee(Integer.toString(rsFinal.getInt("BookingFee")));
						date.setCustRepresentative(rsCustRep.getString("FirstName") + " " + rsCustRep.getString("LastName"));
						date.setComments(rsFinal.getString("Comments"));
						date.setUser1Rating(Integer.toString(rsFinal.getInt("User1Rating")));
						date.setUser2Rating(Integer.toString(rsFinal.getInt("User2Rating")));
						dates.add(date);
					}
				}
			}

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dates;
    }
}