package com.example.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PortfolioController {

    @GetMapping("/about-me")
    public String showAboutMePage() {
        return "about-me";
    }

    @GetMapping("/projects")
    public String showProjectPage() {
        return "projects";
    }
    
    @GetMapping("/blog")
    public String showBlogPage()    {
        return "blog";
    }
    
}
