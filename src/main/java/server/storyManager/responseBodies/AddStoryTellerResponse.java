package server.storyManager.responseBodies;

import server.responseObjects.ResponseBody;

public class AddStoryTellerResponse implements ResponseBody {

    public Integer getStoryTellerId() {
        return storyTellerId;
    }

    public void setStoryTellerId(Integer storyTellerId) {
        this.storyTellerId = storyTellerId;
    }

    private Integer storyTellerId;

    public AddStoryTellerResponse(Integer storyTellerId) {
        this.storyTellerId = storyTellerId;
    }

}
