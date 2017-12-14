package com.tow.spring.websocket.controller;

import com.google.gson.Gson;
import com.tow.spring.websocket.model.ParametresModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping(path = "/test")
public class SimpleController {
    private Gson gson;

    @Autowired
    @Qualifier("gson")
    public SimpleController setGson(Gson gson) {
        this.gson = gson;
        return this;
    }

    @GetMapping(path = "/jsp")
    public ModelAndView getJsp() {
        ModelAndView modelAndview = new ModelAndView("simple");
        return modelAndview;
    }

    @GetMapping(path = "/")
    @ResponseBody
    public String getRB() {
        return "ResponseBody";
    }

    @GetMapping(path = "/params")
    @ResponseBody
    public String getParams(ParametresModel parametresModel, String other) {
        return gson.toJson(parametresModel)+other;
    }
}