package com.calculator.calculator;

import com.calculator.Calc;
import com.calculator.ICalc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    ICalc calcObj = new Calc();

    @GetMapping("/calculator")
    public String calculatorPage(){
        return "calculator";
    }
    @PostMapping("/calculator")
    public String calcApp(@RequestParam(name="problem", required=true) String problem, Model model){
        int result = calcObj.calculate(problem);
        model.addAttribute("resultText", "Result of your problem: ");
        model.addAttribute("result",result);
        return "calculator";
    }

}
