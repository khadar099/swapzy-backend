package com.swapzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index"; // This will map to the index.html template in the templates folder
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // This will map to the login.html template
    }
}
