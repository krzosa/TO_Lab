package com.calculator.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Calculator {
    @GetMapping("/calculator")
    public String calculatorPage(){
        return "calculator";
    }
    @PostMapping("/calculator")
    public String calcApp(){
        return "calculator";
    }

}
