package loginManager.controllers;

import com.google.gson.Gson;
import com.querydsl.core.types.Predicate;
import loginManager.repos.SessionRepository;
import loginManager.repos.UserRepository;
import loginManager.tables.QSession;
import loginManager.tables.QUser;
import loginManager.tables.Session;
import loginManager.tables.User;
import loginManager.utils.LoginUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import responseObjects.GenericResponse;
import responseObjects.ResponseConstants;
import loginManager.responseBodies.LoginSuccessBody;

import java.util.*;

@Controller
@RequestMapping("/login")
public class UserController {
    private static final String USER_CREATED_MSG = "User successfully created";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @PostMapping(path="/create_user")
    public @ResponseBody
    String createNewUser (@RequestParam String firstName, @RequestParam String lastName,
                          @RequestParam String email, @RequestParam String password) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setEmail(email);
        n.setPassword(LoginUtils.get_SHA_512_SecurePassword(password));
        userRepository.save(n);
        return new Gson().toJson(new GenericResponse(ResponseConstants.SUCCESS, USER_CREATED_MSG, null));
    }

    @PostMapping(path="/login_user")
    public @ResponseBody
    String loginUser(@RequestParam String email, @RequestParam String password) {
        Predicate pred  = QUser.user.email.eq(email).and(QUser.user.password.eq(LoginUtils.get_SHA_512_SecurePassword(password)));
        User user = userRepository.findOne(pred);
        Objects.requireNonNull(user, "Could not find any user with matching email and password");

        // Create new session
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session();
        session.setStartTime(new java.sql.Timestamp(DateTime.now().getMillis()));
        session.setSessionId(sessionId);
        session.setUser(user);
        sessionRepository.save(session);

        return new Gson().toJson(new GenericResponse(ResponseConstants.SUCCESS,
                "found user: " + user.getEmail(), new LoginSuccessBody(sessionId)));

    }

    @PostMapping(path="/logout_user")
    public @ResponseBody
    String logoutUser(@RequestParam String sessionId) throws IllegalAccessException {
        User currentUser = authenticateUser(sessionId);
        sessionRepository.delete(sessionRepository
                .findAll(QSession.session.user.eq(currentUser)));

        return new Gson().toJson(new GenericResponse(ResponseConstants.SUCCESS, "Successfully logged out", null));
    }

    public User authenticateUser(String sessionId) throws IllegalAccessException {
        Session currentSession = sessionRepository.findOne(QSession.session.sessionId.eq(sessionId));
        if (currentSession == null)
            throw new IllegalAccessException("Invalid session ID");
        return currentSession.getUser();
    }

}
