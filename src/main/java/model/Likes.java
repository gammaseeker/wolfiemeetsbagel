package model;

public class Likes {
	
	private String likerID;
	private String likeeID;
	private String date;

	public String getLikerID() {
		return likerID;
	}

	public void setLikerID(String likerID) {
		this.likerID = likerID;
	}

	public String getLikeeID() {
		return likeeID;
	}

	public void setLikeeID(String likeeID) {
		this.likeeID = likeeID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
