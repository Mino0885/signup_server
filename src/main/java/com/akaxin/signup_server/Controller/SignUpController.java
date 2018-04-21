package com.akaxin.signup_server.Controller;

import com.akaxin.signup_server.pojo.GroupBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SignUpController {
    @RequestMapping("/signUp")
    public String signUp(HttpServletRequest request) {
        System.out.println(12312321);
        return null;
    }
}
