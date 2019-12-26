package com.calculator.calculator;

import com.calculator.Calc;
import com.calculator.ICalc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@Controller
public class Calculator {

    ICalc calcObj;

    {
        try {
            calcObj = new Calc();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    int result;

    @GetMapping("/calculator")
    public String calculatorPage(){
        return "calculator";
    }
    @PostMapping("/calculator")
    public String calcApp(@RequestParam(name="problem", required=true) String problem, Model model){
        model.addAttribute("resultText", "Result of your problem: ");
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
