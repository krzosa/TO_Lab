package com.calculator.Login;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public boolean isValid(String login, String pass){
        if(login.equals("login") && pass.equals("pass"))
            return true;
        return false;
    }
}
