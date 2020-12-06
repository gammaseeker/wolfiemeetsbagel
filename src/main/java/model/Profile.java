package model;

public class Profile {
	
	private String profileID;
	private String profileName;
	private String age;
	private String address;
	private String gender;
	private String phy_char;
	private String interests;
	private String photo;
	private String geoRange;
	private String ageRange;
	private int rating;
	private String dateOfLastAct;
	
	public String getDateOfLastAct() {
		return dateOfLastAct;
	}
	
	public void setDateOfLastAct(String dateOfLastAct) {
		this.dateOfLastAct = dateOfLastAct;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhy_char() {
		return phy_char;
	}

	public void setPhy_char(String phy_char) {
		this.phy_char = phy_char;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public String getGeoRange() {
		return geoRange;
	}

	public void setGeoRange(String geoRange) {
		this.geoRange = geoRange;
	}
}
