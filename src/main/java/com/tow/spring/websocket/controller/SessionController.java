package com.tow.spring.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("pet")
public class SessionController {
    @GetMapping(path = "/redirect")
    public String redirect(@RequestParam(value = "key", required = false) String value,
                           @RequestParam(value = "username", required = false) String username,
                           RedirectAttributes model) {
        model.addFlashAttribute("value", value);
        model.addAttribute("username", username);
        return "redirect:/spitter/{username}";
    }

    @GetMapping(path = "/spitter/{username}")
    public String spitter(@PathVariable String username,
                          Model model) {
        return "profile";
    }

    @GetMapping(path = "/clear")
    public String clear() {
        return "profile";
    }

    @GetMapping(path = "/rest")
    @ResponseBody
    public String rest() {
        return "rest Ok";
    }

    @GetMapping(path = "/rest_model")
    @ResponseBody
    public String restModel(Model model) {
        model.asMap();

        return "rest Ok";
    }
    @GetMapping(path = "/rest_session")
    @ResponseBody
    public String restModel(HttpSession session) {
        session.isNew();
        return "rest Ok";
    }

}
