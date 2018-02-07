package server.storyManager.RequestBodies;

import java.util.Objects;

public class AddStoryTellerBody {

    private String firstName;

    private String lastName;

    private String biography;

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


    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void validate() {
        Objects.requireNonNull(firstName, "Story teller must have first name");
        lastName = lastName != null ?  lastName : "";
        Objects.requireNonNull(biography);
    }

}
