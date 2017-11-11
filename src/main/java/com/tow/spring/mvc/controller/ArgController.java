package com.tow.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArgController {
    @Value("${lol.test}")
    private String lolTestSpEL;

    @Value("lol.test")
    private String lolTestValue;

    @GetMapping(path = "arg")
    @ResponseBody
    public String getArg() {
        return lolTestSpEL + " " + lolTestValue;
    }
}
