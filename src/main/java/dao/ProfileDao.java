package dao;

import model.Customer;
import model.Profile;

import java.util.ArrayList;
import java.util.List;

public class ProfileDao {
    /*
     * This class handles all the database operations related to the customer table
     */

    public List<Profile> getProfiles() {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

    public List<Profile> getProfilesByAge(String age) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

    public List<Profile> getProfilesByWeight(String weight) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

    public List<Profile> getProfilesByHeight(String height) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

    public List<Profile> getProfilesByHairColor(String hairColor) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

}
