package com.sparta.homework.controller;

import com.sparta.homework.model.UserRoleEnum;
import com.sparta.homework.security.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("username", userDetails.getUsername());

        if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }

        return "index";
    }
}
