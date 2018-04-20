package com.akaxin.signup_server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SignUpController {
    @RequestMapping("/signUp")
    public String signUp(HttpServletRequest request) {
        return null;
    }
}
