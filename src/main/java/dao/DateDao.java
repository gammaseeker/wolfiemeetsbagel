package dao;

import model.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DateDao {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/wolfiemeetsbagel";

	private String createDateID(String profile1, String profile2, String dateTime) {
		String varstr = profile1 + profile2 + dateTime;
		int hc = Math.abs(varstr.hashCode());
		return Integer.toString(hc);
	}

    public String addDate(Date date) {
    	try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			st.execute(""
				+ "INSERT INTO date VALUES (\'"
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
			return "Failed";
    	}
    	return "Success";
    }


    public List<Date> getDatesByCalendar(String calendarDate) {

		List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, "root", "root");
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(""
					+ "SELECT * FROM date WHERE CAST(Date_Time AS DATE) = CAST(\'" + calendarDate + "\' AS DATE)"); 
			while(rs.next()) {
				String profile1 = rs.getString("Profile1");
				String profile2 = rs.getString("Profile2");
				String dateTime = rs.getString("Date_Time");
				String dateID = createDateID(profile1, profile2, dateTime);

				Date date = new Date();
				date.setDateID(dateID);
				date.setUser1ID(profile1);
				date.setUser2ID(profile2);
				date.setDate(dateTime);
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
				date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
				dates.add(date);
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
				String profile1 = rs.getString("Profile1");
				String profile2 = rs.getString("Profile2");
				String dateTime = rs.getString("Date_Time");
				String dateID = createDateID(profile1, profile2, dateTime);

				Date date = new Date();
				date.setDateID(dateID);
				date.setUser1ID(profile1);
				date.setUser2ID(profile2);
				date.setDate(dateTime);
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
				date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
				dates.add(date);
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
					String profile1 = rs.getString("Profile1");
					String profile2 = rs.getString("Profile2");
					String dateTime = rs.getString("Date_Time");
					String dateID = createDateID(profile1, profile2, dateTime);

					Date date = new Date();
					date.setDateID(dateID);
					date.setUser1ID(profile1);
					date.setUser2ID(profile2);
					date.setDate(dateTime);
					date.setGeolocation(rs.getString("Location"));
					date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
					date.setCustRepresentative(rs.getString("CustRep"));
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
				String profile1 = rs.getString("Profile1");
				String profile2 = rs.getString("Profile2");
				String dateTime = rs.getString("Date_Time");
				String dateID = createDateID(profile1, profile2, dateTime);

				Date date = new Date();
				date.setDateID(dateID);
				date.setUser1ID(profile1);
				date.setUser2ID(profile2);
				date.setDate(dateTime);
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
				date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
				dates.add(date);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return dates;
    }


    public List<Date> getOpenDates() {

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

    public String setNewDate(String user1, String user2) {
        return "Successfull date b/w " + user1 + " and " + user2;
    }

    public String cancelDate(String dateID) {
        return "Date - " + dateID + " is now cancelled";
    }

    public String commentDate(String dateID, String comment) {
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
				String profile1 = rs.getString("Profile1");
				String profile2 = rs.getString("Profile2");
				String dateTime = rs.getString("Date_Time");
				String dateID = createDateID(profile1, profile2, dateTime);

				Date date = new Date();
				date.setDateID(dateID);
				date.setUser1ID(profile1);
				date.setUser2ID(profile2);
				date.setDate(dateTime);
				date.setGeolocation(rs.getString("Location"));
				date.setBookingfee(Integer.toString(rs.getInt("BookingFee")));
				date.setCustRepresentative(rs.getString("CustRep"));
				date.setComments(rs.getString("Comments"));
				date.setUser1Rating(Integer.toString(rs.getInt("User1Rating")));
				date.setUser2Rating(Integer.toString(rs.getInt("User2Rating")));
				dates.add(date);
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

    public List<Date> getPendingDates(String user) {

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

    public List<Date> getPastDates(String user) {

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


    public String getMostPopularLocation(String user) {
        return "Jersey City";
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
}