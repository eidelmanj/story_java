package server.storyManager.controllers;

import com.google.gson.Gson;
import org.springframework.data.domain.PageRequest;
import server.loginManager.controllers.UserController;
import server.loginManager.repos.SessionRepository;
import server.loginManager.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import server.responseObjects.GenericResponse;
import server.responseObjects.ResponseConstants;
import server.storyManager.RequestBodies.AddStoryTellerBody;
import server.storyManager.RequestBodies.CreateStoryBody;
import server.storyManager.repos.StoryRepository;
import server.storyManager.repos.StoryTellerRepository;
import server.storyManager.responseBodies.AddStoryTellerResponse;
import server.storyManager.tables.QStory;
import server.storyManager.tables.QStoryTeller;
import server.storyManager.tables.Story;
import server.storyManager.tables.StoryTeller;

import java.util.Objects;

@Controller
@RequestMapping("/story_manager")
public class StoryController {
    private Gson gson = new Gson();


    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private StoryTellerRepository storyTellerRepository;

    @PostMapping(path="/create_story")
    public @ResponseBody String createNewStory(@RequestParam String sessionId,
                                               @RequestBody String payload) throws IllegalAccessException {
        User currentUser = new UserController().authenticateUser(sessionId, sessionRepository);

        CreateStoryBody createStoryBody = gson.fromJson(payload, CreateStoryBody.class);
        createStoryBody.validate();
        Story newStory = new Story();
        newStory.setDescription(createStoryBody.getDescription());
        newStory.setTitle(createStoryBody.getTitle());
        newStory.setOwner(currentUser);

        StoryTeller storyTeller = storyTellerRepository.findOne(QStoryTeller.storyTeller.id.eq(createStoryBody.getStoryTellerId()));
        Objects.requireNonNull(storyTeller, "Story teller requested does not exist");
        newStory.setStoryTeller(storyTeller);
        storyRepository.save(newStory);
        return gson.toJson(new GenericResponse(ResponseConstants.SUCCESS, "Successfully created new story", null));
    }


    @PostMapping(path="/add_story_teller")
    public @ResponseBody String addStoryTeller(@RequestParam String sessionId,
                                               @RequestBody String payload) throws IllegalAccessException {
        User currentUser = new UserController().authenticateUser(sessionId, sessionRepository);

        AddStoryTellerBody addStoryTellerBody = gson.fromJson(payload, AddStoryTellerBody.class);
        addStoryTellerBody.validate();

        StoryTeller newStoryTeller = new StoryTeller();
        newStoryTeller.setFirstName(addStoryTellerBody.getFirstName());
        newStoryTeller.setLastName(addStoryTellerBody.getLastName());
        newStoryTeller.setManager(currentUser);
        storyTellerRepository.save(newStoryTeller);
        return gson.toJson(new GenericResponse(ResponseConstants.SUCCESS, "Successfully added story teller", new AddStoryTellerResponse(newStoryTeller.getId())));
    }

    @PostMapping(path="/search_stories")
    public @ResponseBody String searchStories(@RequestParam @RequestBody String payload) {
        // TODO

        PageRequest pageRequest = new PageRequest(0, 1);

        storyRepository.findAll(QStory.story.id.eq(1), pageRequest);
        return gson.toJson(new GenericResponse(ResponseConstants.SUCCESS, "Successfully added story teller", null));
    }

}
