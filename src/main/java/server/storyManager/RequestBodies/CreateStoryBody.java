package server.storyManager.RequestBodies;

import java.util.Objects;

public class CreateStoryBody {


    private String title;


    private String description;

    private Integer storyTellerId;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStoryTellerId() {
        return storyTellerId;
    }

    public void setStoryTellerId(Integer storyTellerId) {
        this.storyTellerId = storyTellerId;
    }

    public void validate() {
        Objects.requireNonNull(title, "Must provide a title");
        Objects.requireNonNull(description, "Must provide a description");
        Objects.requireNonNull(storyTellerId, "Must provide a story teller");
    }
}
