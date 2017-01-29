package com.firefly.captcha.controller;

import com.firefly.captcha.model.entity.User;
import com.firefly.captcha.repository.UserRepository;
import com.firefly.captcha.service.LogonService;
import com.firefly.captcha.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

import static com.firefly.captcha.utils.JsonUtils.*;

/**
 * Created by rodion on 29.01.2017.
 */
@RestController
public class LoginController {

    @Autowired
    private LogonService logonService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public String checkLogin() {
        HttpSession session = SessionUtils.getSession();

        User user = (User) session.getAttribute(SessionUtils.SessionAttributes.USER_ATTIBUTE.getAttribute());
        if (user != null) {
            return addBasicUserInfo(success(), user).toString();
        }


        return failure().toString();
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public String login(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "password", required = false) String password, @RequestParam Map<String, String> params) {

        User user = userRepository.findByLastName(name).get(0);

        HttpSession session = SessionUtils.getSession();

        boolean newUser = false;
        if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute(SessionUtils.SessionAttributes.USER_ATTIBUTE.getAttribute(), user);
            } else {
                return addError(failure(), "wrong password").toString();
            }
        }

        return addBasicUserInfo(success(), user, newUser).toString();
    }
}
