package com.hcmc.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePages {

    @GetMapping(value = {"/" , "/home" , ""})
    public String homepage(){
        return "index";
    }

}
