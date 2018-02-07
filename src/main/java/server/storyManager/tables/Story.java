package server.storyManager.tables;

import server.common.tables.Country;
import server.common.tables.Language;
import server.loginManager.tables.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="STORY")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="STORY_ID")
    private Integer id;

    @NotNull
    private String title;

    private String description;

    @ManyToOne(targetEntity=Country.class,  fetch=FetchType.EAGER)
    private Country country;
    @ManyToOne(targetEntity=Language.class,  fetch=FetchType.EAGER)
    private Language language;



    @ManyToOne(targetEntity=StoryTeller.class,  fetch=FetchType.EAGER)
    private StoryTeller storyTeller;


    @ManyToOne(targetEntity=User.class,  fetch=FetchType.EAGER)
    private User owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public StoryTeller getStoryTeller() {
        return storyTeller;
    }

    public void setStoryTeller(StoryTeller storyTeller) {
        this.storyTeller = storyTeller;
    }


}
