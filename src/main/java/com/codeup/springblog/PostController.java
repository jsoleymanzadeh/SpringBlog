package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String postsIndex(Model model) {
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String singlePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getPostById(id));
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Post post) {
        post.setUser(userDao.getUserById(1));
        postDao.save(post);
        return "redirect:/posts";
    }
    @RequestMapping(path = "/posts/{id}/edit", method = RequestMethod.GET)
    public String editPostForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getPostById(id));
        return "posts/edit";
    }
    @RequestMapping(path = "/posts/edit", method = RequestMethod.POST)
    public String editPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }
}