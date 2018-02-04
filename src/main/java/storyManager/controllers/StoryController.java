package storyManager.controllers;

import loginManager.controllers.UserController;
import loginManager.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import storyManager.repos.StoryRepository;

@Controller
@RequestMapping("/story_manager")
public class StoryController {

    @Autowired
    private StoryRepository storyRepository;

    @PostMapping(path="/create_story")
    public @ResponseBody String createNewStory(@RequestParam String sessionId,
                                               @RequestBody String payload) throws IllegalAccessException {
        User currentUser = new UserController().authenticateUser(sessionId);

    }

}
