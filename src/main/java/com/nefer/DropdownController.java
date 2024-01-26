package com.nefer;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DropdownController {

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
        System.out.println("Dropdown 1: " + dropdown1);
        System.out.println("Dropdown 2: " + dropdown2);
        System.out.println("Dropdown 3: " + dropdown3);
        System.out.println("Dropdown 4: " + dropdown4);
        System.out.println("Dropdown 5: " + dropdown5);
        System.out.println("Dropdown 5: " + dropdown6);

        // You can add your business logic here

        return "redirect:/";  // Redirect to the home page after processing
    }
}
