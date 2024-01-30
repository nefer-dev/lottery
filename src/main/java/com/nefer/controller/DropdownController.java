package com.nefer.controller;


import com.nefer.LotteryNumberInputValidator;
import com.nefer.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DropdownController {
    
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/")
    public String showDropdownPage() {
        return "index";
    }

    @PostMapping("/")
    public String handleFormSubmission(
            @RequestParam(value="dropdown1") String dropdown1,
            @RequestParam(value="dropdown2") String dropdown2,
            @RequestParam(value="dropdown3") String dropdown3,
            @RequestParam(value="dropdown4") String dropdown4,
            @RequestParam(value="dropdown5") String dropdown5,
            @RequestParam(value="dropdown6") String dropdown6) {

        // Process the selected values from the dropdowns
        ArrayList<Integer> inputLotteryNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        LotteryNumberInputValidator lotteryNumberInputValidator = new LotteryNumberInputValidator();

        boolean result = lotteryNumberInputValidator.checkForDuplicateLotteryNumbers(inputLotteryNumbers);

        if(!result) {
            return "redirect:/";
        }
        else {
            return "done";
        }

    }
    
    @GetMapping("/test")
    public String test() {
        System.out.println("this.memberRepository = " + this.memberRepository);
        System.out.println(this.memberRepository.findByName("전지윤").getName().equals("전지윤"));
        return "index";
    }
}
