package storyManager.tables;

import common.tables.Country;
import common.tables.Language;
import loginManager.tables.User;

import javax.persistence.*;

@Entity
@Table(name="STORY")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="STORY_ID")
    private Integer id;

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


}
