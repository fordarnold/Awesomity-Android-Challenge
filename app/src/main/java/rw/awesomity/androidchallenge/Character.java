package rw.awesomity.androidchallenge;

/**
 * A Character is a what is displayed in each list item of the RecyclerView
 */
public class Character {

    private String name, location, powers;

    public Character(){

    }

    public Character(String name, String location, String powers) {
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
}
