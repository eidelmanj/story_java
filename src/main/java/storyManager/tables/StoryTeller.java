package storyManager.tables;

import common.tables.Country;
import common.tables.Language;

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

}
