package com.nefer.controller;

import com.nefer.domain.member.Member;
import com.nefer.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/admin")
    public String home(){
        return "admin-login";
    }

    @PostMapping("/admin")
    public String login(@RequestParam("pw") String password){
        if(password.equals("1q2w3e4r!")) {
            return "admin-modify";
        }
        else{
            return "admin-login";
        }
    }

    @PostMapping("/admin/member/add")
    public String addMember(@RequestParam("memberadd") String name) {
        this.memberRepository.add(name);

        Member memberAdded = this.memberRepository.findByName(name);
        System.out.println(memberAdded.getName() + " add complete");

        return "admin-modify";

    }

    @PostMapping("/admin/member/delete")
    public String deleteMember(@RequestParam("memberdelete") String name) {
        this.memberRepository.delete(name);
        return "admin-modify";

    }
}
