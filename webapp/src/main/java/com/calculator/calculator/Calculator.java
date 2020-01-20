package com.calculator.calculator;

import com.calculator.Calc;
import com.calculator.UserAction.UserActionEntity;
import com.calculator.UserAction.UserActionRepository;
import com.calculator.ICalc;
import com.calculator.Login.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {

    @Autowired
    UserActionRepository UARepo;

    ICalc calcObj = new Calc();
    @PostMapping("/calculator")
    public String calcApp(@RequestParam(name="problem", required=true) String problem,
                          Model model){
        model.addAttribute("resultText", "Result of your problem: ");
        UARepo.save(new UserActionEntity(LoginController.LOGIN, problem));
        int result = 0;
        try {
            result = calcObj.calculate(problem);
        }
        catch(Exception e){
            model.addAttribute("resultText", "invalid Entry!");
        }
        model.addAttribute("result",result);
        return "calculator";
    }

}
