package com.hariharan.mvcemployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String redirect(){
        return "redirect:/employees/list";
    }
}
