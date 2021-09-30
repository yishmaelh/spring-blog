package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.EmailService;

import java.util.List;

@Controller
public class PostController {

    private final UserRepository userDao;
    private final PostRepository postDao;
    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String showPosts(Model model) {
        List<Post> allPosts = postDao.findAll();
        model.addAttribute("posts", allPosts);
        return "post/index";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable long id, Model model) {
        Post post = postDao.getById(id);
        model.addAttribute("postId", id);
        model.addAttribute("post", post);
        return "post/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreatePostForm() {
        return "view form for creating a new post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }

    @GetMapping("/posts/edit/{id}")
    public String showEditPostForm(@PathVariable long id, Model model) {
        Post postToEdit = postDao.getById(id);
        model.addAttribute("id", postToEdit.getId());
        return "post/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ) {

        Post postToUpdate = postDao.getById(id);


        postToUpdate.setTitle(title);
        postToUpdate.setBody(body);

        postDao.save(postToUpdate);

        return "redirect:/posts";

    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        Post postToDelete = postDao.getById(id);
        postDao.delete(postToDelete);

        return "redirect:/posts";

    }

}
