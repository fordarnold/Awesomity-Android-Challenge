package rw.awesomity.androidchallenge;

import android.net.Uri;

/**
 * A Character is a what is displayed in each list item of the RecyclerView.
 *
 * This class allows us to initialise data for a Character.
 *
 */
public class Character {

    private String name, location, powers;
    private Uri photo;

    public Character(){

    }

    public Character(String name, String location, String powers, String photo) {
        this.name = name;
        this.location = location;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }
}
