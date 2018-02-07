package server.storyManager.tables;

import server.common.tables.Country;
import server.common.tables.Language;
import server.loginManager.tables.User;

import javax.persistence.*;

@Entity
public class StoryTeller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;



    private String firstName;
    private String lastName;
    private String biography;

    @ManyToOne(targetEntity=Country.class,  fetch=FetchType.EAGER)
    private Country countryOfOrigin;
    @ManyToOne(targetEntity=Language.class,  fetch=FetchType.EAGER)
    private Language nativeLanguage;

    @ManyToOne(targetEntity = User.class, fetch=FetchType.EAGER)
    private User manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Country getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(Country countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Language getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(Language nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

}
