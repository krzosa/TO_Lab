package com.calculator.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Calculator {
    @RequestMapping("/calculator")
    public String calculatorPage(){
        return "calculator";
    }

}
