
package com.company.controller;

import com.company.dao.inter.UserDaoInter;
import com.company.form.UserSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserSearchController {

    @Autowired
    @Qualifier("userDao")
    private UserDaoInter userDao;

    private final UserSearchForm usf=new UserSearchForm();

//    @RequestMapping(method = RequestMethod.GET, value="users")
//    public ModelAndView index2(@RequestParam(value="name",required = false) String name,
//                               @RequestParam(value="surname",required = false) String surname){
//        User user=new User();
//        user.setName(name);
//        user.setSurname(surname);
//        ModelAndView mv=new ModelAndView("usersJSTL");
//        List list=userDao.getAll(name,surname);
//        usf.setName(name);
//        usf.setSurname(surname);
//        mv.addObject("list",list);
//        mv.addObject("user",usf);
//        return mv;
//    }

    @RequestMapping(method = RequestMethod.GET, value="usersearch")
    public ModelAndView index3( @ModelAttribute("user") UserSearchForm usf){
        ModelAndView mv = new ModelAndView("usersJSTL");
        List list = userDao.getAll(usf.getName(), usf.getSurname());
        mv.addObject("list", list);
        mv.addObject("user",usf);
        return mv;
    }

}
