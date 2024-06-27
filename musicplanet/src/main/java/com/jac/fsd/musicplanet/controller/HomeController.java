package com.jac.fsd.musicplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String index(){
        return "login";
    }

    @GetMapping("/me")
    public String me() {
        return "me";
    }
}
