package com.jac.fsd.musicplanet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountFavesController {

    @GetMapping("/user/favorites")
    public String favorites(Model model) {
        model.addAttribute("customvar", "baboom");
        return "favorites";
    }
}
