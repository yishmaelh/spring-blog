package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userDao;

    public UserController() {
    }


    @GetMapping("/user/create")
    public String createUserForm() {
        return "user/create";
    }

    @GetMapping("/user/{username}/ads")
    public String showUserAds(
            @PathVariable String username,
            Model model
    ) {

        User userToDisplay = userDao.getByUsername(username);

        model.addAttribute("user", userToDisplay);


        return "user/displayAds";
    }

    @PostMapping("/user/create")
    @ResponseBody
    public String createUser(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password
    ) {
        System.out.println("Username " + username);
        System.out.println("Password " + password);

        return "User Created";
    }


}
