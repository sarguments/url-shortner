package me.saru.urlshortner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @GetMapping("")
    public String home() {
        return "redirect:https://daum.net";
    }

    @GetMapping("/{path}")
    public String redirect(@PathVariable String path) {
        return "redirect:" + path;
    }
}
