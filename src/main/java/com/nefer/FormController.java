package com.nefer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class FormController {
    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/members/new")
    public String userForm(){
        System.out.println("userRepository = " + userRepository);
        return "form";
    }

    @PostMapping("/members/new")
    public String userSubmit(@RequestParam("name") String name) {

        System.out.println("name = " + name);
        return "redirect:/";

    }
}
