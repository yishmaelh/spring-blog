package com.codeup.springblog.controllers;

import com.codeup.springblog.controllers.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String showPosts(Model model) {
        List<Post> allPosts = new ArrayList<>();

        allPosts.add(new Post("post!", "post1 body"));
        allPosts.add(new Post("post@", "post2 body"));

        model.addAttribute("posts", allPosts);
        return "post/index";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable int id, Model model) {

        Post post = new Post("Fun title", "Fun body");
        model.addAttribute("postId", id);
        model.addAttribute("post", post);

        return "post/show";
    }

}
