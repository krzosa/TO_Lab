package com.calculator.Login;

import com.calculator.Calc;
import com.calculator.Database.Logging.Entities.UserActionEntity;
import com.calculator.Database.Logging.Repositories.UserActionSpringDataRepository;
import com.calculator.ICalc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    public static String LOGIN = "Karol";

    @Autowired
    UserValidation uv;
    @Autowired
    UserActionSpringDataRepository UARepo;

    @GetMapping(value= "/index")
    public String loginPage(){
        return "index";
    }

    @PostMapping(value = "/index")
    public String login(@RequestParam(name="login", required = true) String login,
                        @RequestParam(name="pass", required = true) String pass,
                        Model model){
        if(uv.isValid(login, pass)) {
            LOGIN=login;
            UARepo.save(new UserActionEntity(login, "valid login"));
            model.addAttribute("login", login);
            return "calculator";
        }
        else{
            UARepo.save(new UserActionEntity(login, "invalid login"));
            model.addAttribute("LoginError", "Invalid Credentials!");
            return "index";
        }
    }
}
