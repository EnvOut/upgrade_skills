package com.tow.spring.form.controller;

import com.tow.spring.form.model.User;
import com.tow.spring.form.service.UserService;
import com.tow.spring.form.validator.UserFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserFormValidator userFormValidator;
    @Autowired
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userFormValidator);
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        LOG.debug("index()");
        return "redirect:/users";
    }

    @GetMapping(value = "/users")
    public String showAllUsers(Model model) {
        LOG.debug("showAllUsers()");
        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    @PostMapping(value = "/users")
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
                                   BindingResult result,
                                   Model model,
                                   final RedirectAttributes redirectAttributes) {
        LOG.debug("saveOrUpdateUser() : {}", user);
        String results = "redirect:/users/" + user.getId();
        if (result.hasErrors()) {
            populateDefaultModel(model);
            results = "users/userform";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (user.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "User added successfully");
            } else {
                redirectAttributes.addFlashAttribute("msg", "User updated successfully");
            }

            userService.saveOrUpdate(user);
        }
        return results;
    }

    @GetMapping(value = "/users/add")
    public String showAdduserForm(Model model) {
        LOG.debug("showAdduserForm()");

        User user = new User();

        // set default value
        user.setName("mkyong123");
        user.setEmail("test@gmail.com");
        user.setAddress("abc 88");
        user.setNewsletter(true);
        user.setSex("M");
        user.setFramework(new ArrayList<String>(Arrays.asList("Spring MVC", "GWT")));
        user.setSkill(new ArrayList<String>(Arrays.asList("Spring", "Grails", "Groovy")));
        user.setCountry("SG");
        user.setNumber(2);
        model.addAttribute("userForm", user);

        populateDefaultModel(model);

        return "users/userform";
    }

    @GetMapping(value = "/users/{id}/update")
    public String showUpdateUserForm(@PathVariable("id") int id,
                                     Model model) {
        LOG.debug("showUpdateUserForm() : {}", id);

        User user = userService.findById(id);
        model.addAttribute("userForm", user);

        populateDefaultModel(model);

        return "users/userform";
    }

    @PostMapping(value = "/users/{id}/delete")
    public String deleteUser(@PathVariable("id") int id,
                             final RedirectAttributes redirectAttributes) {
        LOG.debug("deleteUser() : {}", id);

        userService.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted!");

        return "redirect:/users";
    }

    @GetMapping(value = "/users/id}")
    public String showUser(@PathVariable("id") int id,
                           Model model) {
        LOG.debug("showUser() : {}", id);

        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);

        return "users/show";
    }

    private void populateDefaultModel(Model model) {

        List<String> frameworksList = new ArrayList<String>();
        frameworksList.add("Spring MVC");
        frameworksList.add("Struts 2");
        frameworksList.add("JSF 2");
        frameworksList.add("GWT");
        frameworksList.add("Play");
        frameworksList.add("Apache Wicket");
        model.addAttribute("frameworkList", frameworksList);

        Map<String, String> skill = new LinkedHashMap<String, String>();
        skill.put("Hibernate", "Hibernate");
        skill.put("Spring", "Spring");
        skill.put("Struts", "Struts");
        skill.put("Groovy", "Groovy");
        skill.put("Grails", "Grails");
        model.addAttribute("javaSkillList", skill);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        model.addAttribute("numberList", numbers);

        Map<String, String> country = new LinkedHashMap<String, String>();
        country.put("US", "United Stated");
        country.put("CN", "China");
        country.put("SG", "Singapore");
        country.put("MY", "Malaysia");
        model.addAttribute("countryList", country);
    }
}
