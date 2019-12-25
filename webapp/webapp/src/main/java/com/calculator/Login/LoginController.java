package com.calculator.Login;

import com.calculator.Calc;
import com.calculator.ICalc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    UserValidation uv;

    @GetMapping(value= "/index")
    public String loginPage(){
        return "index";
    }

    @PostMapping(value = "/index")
    public String login(@RequestParam(name="login", required = true) String login,
                        @RequestParam(name="pass", required = true) String pass,
                        Model model){
        if(uv.isValid(login, pass)) {
            model.addAttribute("login", login);
            model.addAttribute("pass", pass);
            return "calculator";
        }
        else{
            model.addAttribute("LoginError", "Invalid Credentials!");
            return "index";
        }
    }
}
