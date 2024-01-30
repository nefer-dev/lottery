package com.nefer.controller;

import com.nefer.Member;
import com.nefer.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class FormController {
    
    @Autowired
    private MemberRepository memberRepository;
    
    @GetMapping("/members")
    public String userForm(){
        System.out.println("memberRepository = " + memberRepository);
        return "form";
    }

    @PostMapping("/members")
    public String userSubmit(@RequestParam("name") String name) {

        Member member = memberRepository.findByName(name);
        if(member == null) {
            return "form-no-name";
        }
        else {
            return "index";
        }

    }
}
