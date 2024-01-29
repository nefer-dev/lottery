package com.nefer;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class FormController {
    @GetMapping("/members")
    public String userForm(){
        return "form";
    }

    @PostMapping("/members")
    public String userSubmit(@RequestParam("name") String name) {

        System.out.println("name = " + name);
        return "redirect:/";

    }
}
