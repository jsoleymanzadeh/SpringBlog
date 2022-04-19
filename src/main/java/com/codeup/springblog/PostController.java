package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String postsIndex(Model model) {
        ArrayList<Post> allPosts = new ArrayList<>();
        allPosts.add(new Post("title1", "body1"));
        allPosts.add(new Post("title2", "body2"));
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String singlePost(@PathVariable int id, Model model) {
        String title = "Test Title";
        String body = "Test Body";
        model.addAttribute("post", new Post(title, body));
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPostForm() {
        return "view the form for creating a post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}
