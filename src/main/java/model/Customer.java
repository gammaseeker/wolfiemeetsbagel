package model;

public class Customer {

    /*
     * This class is a representation of the customer table in the database
     * Each instance variable has a corresponding getter and setter
     */

    private String userID;
    private String userSSN;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String telephone;
    private String email;
    private String accNum;
    private String accCreateDate;
    private String ppp;
    private String dateLastActive;
    private String creditCard;
    private String password;
    private int rating;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "The Customer Details are: <br/>Customer ID=" + userID + "<br/>First Name=" + firstName + "<br/>Last Name=" + lastName
                + "<br/>Address=" + address + "<br/>City=" + city + "<br/>State=" + state + "<br/>Zip Code=" + zipCode
                + "<br/>Telephone=" + telephone + "<br/>Email=" + email + "<br/>Credit Card=" + creditCard + "<br/>Rating=" + rating;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getAccCreateDate() {
        return accCreateDate;
    }

    public void setAccCreateDate(String accCreateDate) {
        this.accCreateDate = accCreateDate;
    }

    public String getPpp() {
        return ppp;
    }

    public void setPpp(String ppp) {
        this.ppp = ppp;
    }

    public String getDateLastActive() {
        return dateLastActive;
    }

    public void setDateLastActive(String dateLastActive) {
        this.dateLastActive = dateLastActive;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserSSN() {
        return userSSN;
    }

    public void setUserSSN(String userSSN) {
        this.userSSN = userSSN;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
}
