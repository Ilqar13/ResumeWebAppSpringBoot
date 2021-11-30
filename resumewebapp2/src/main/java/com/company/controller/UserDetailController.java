package com.company.controller;

import com.company.dao.inter.*;
import com.company.entity1.Country;
import com.company.entity1.User;
import com.company.form.UserDetailsForm;
import com.company.util.FileNameUtil;
import files2.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Controller
@ResponseBody
public class UserDetailController {
    @Autowired
    @Qualifier("userDao")
    private  UserDaoInter userDao;
    @Autowired
    @Qualifier("countryDao")
    private  CountryDaoInter countryDao;
    @Autowired
    @Qualifier("skillDao")
    private SkillDaoInter skillDao;
    @Autowired
    @Qualifier("employmentHistoryDao")
    private  EmploymentHistoryDaoInter employmentHistoryDao;
    @Autowired
    @Qualifier("userSkillDao")
    private  UserSkillDaoInter userSkillDao;
    @Autowired
    @Qualifier("countries")
    private  List<Country> countries;
    @Autowired
    private ServletContext context;

    @RequestMapping(method = RequestMethod.GET ,value = "/userdetails")
    public ModelAndView  getUserDetails(@RequestParam("id") String id){
        try {
            ModelAndView mv = new ModelAndView();
            UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String loggedInUserId=userDao.getByGmail(userDetails.getUsername()).getId()+"";
            if(!loggedInUserId.equals(id) && getAuthorityList(userDetails.getAuthorities()).contains("ROLE_USER")){
                mv.setViewName("redirect:/userdetails?id="+userDao.getByGmail(userDetails.getUsername()).getId());
            }else {
                User user = userDao.getById(id);
                String path = context.getRealPath("/");
                if (!FileNameUtil.getFileNameList(path + "profilepictures").contains(user.getUserImageName())) {
                    FileUtility.writeBytes(path + user.getUserImageName(),
                            FileUtility.readBytesFromInputStream(user.getUserImage().getBinaryStream()));
                }
                UserDetailsForm uds = new UserDetailsForm(Objects.requireNonNull(user),
                        employmentHistoryDao.getEmploymentHistoryByUserId(Integer.parseInt(id)));
                mv.setViewName("userdetails2JSTL");
                mv.addObject("allUserdetail", uds);
                mv.addObject("countries", countries);
                mv.addObject("skills", skillDao.getAllSkillNotsignedForUser(Integer.parseInt(id)));
                mv.addObject("userSkillList", userSkillDao.getAllSkillByUserId(Integer.parseInt(id)));
            }
             return mv;
        }catch (Exception ex){
            ModelAndView mv = new ModelAndView("/error");
            mv.addObject("msg", ex.getMessage());
            return mv;
        }
    }

    @RequestMapping(method = RequestMethod.POST,value = "/userdetails")
    public ModelAndView postUserDetails(@ModelAttribute("allUserdetail") UserDetailsForm userDetailsForm, @RequestParam("profilePhoto") MultipartFile multipartFile, HttpServletRequest request){
        try {
            User user=userDao.getById(userDetailsForm.getId());
            if(multipartFile.getBytes().length>0) {
                new File(context.getRealPath("/").concat(user.getUserImageName())).delete();
                user.setUserImageName("profilepictures\\"
                        + multipartFile.getOriginalFilename().replace(".jpg", "")
                        + userDetailsForm.getFullName()
                        + userDetailsForm.getId() + ".jpg");
                user.setUserImage(new SerialBlob(multipartFile.getBytes()));
            }
            userDetailsForm.setAndGetUserProperties(user);
            userSkillDao.removeAllUserSkills(Integer.parseInt(userDetailsForm.getId()));
            String[] skillIds=request.getParameterValues("skillID");
            if(skillIds!=null) {
                user.setUserSkillList(userSkillDao.turnToUserSkillList(Integer.parseInt(userDetailsForm.getId()),
                        skillIds, request.getParameterValues("percentofskill")));
            }

            userDao.updateUser(user);
            employmentHistoryDao.updateEmploymentHistory(userDetailsForm.seAndGetEmploymentHistoryProperties
                    (employmentHistoryDao.getEmploymentHistoryByUserId(Integer.parseInt(userDetailsForm.getId()))));
            return getUserDetails(userDetailsForm.getId());
        }catch(Exception ex){
            ModelAndView mv = new ModelAndView("/error");
            mv.addObject("msg", ex.getMessage());
            return mv;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST,value="/user-removal")
    public String deleteUser(@RequestParam("deletedID") String id){
        userDao.removeUser(Integer.parseInt(id));
      return "redirect:/usersearch";
    }

    private List<String> getAuthorityList(Collection<? extends GrantedAuthority> collection){
        List<String> list=new ArrayList<>();
        for (GrantedAuthority ga:collection){
            list.add(ga.getAuthority());
        }
        return list;
    }
}


