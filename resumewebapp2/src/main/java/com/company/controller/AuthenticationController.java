package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthenticationController {

    @RequestMapping(method = {RequestMethod.GET},value = "/login")
    public String getLogin(){
        return "/login";
    }

    @RequestMapping(method = {RequestMethod.GET},value = "/logout")
    public String getLogout(){
        return "logout";
    }

}
