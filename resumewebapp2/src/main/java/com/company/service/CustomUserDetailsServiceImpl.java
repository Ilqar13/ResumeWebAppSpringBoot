package com.company.service;

import com.company.dao.inter.UserDaoInter;
import com.company.entity1.User;
import com.company.entity1.UserAuthority;
import com.company.entity1.UserRole;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userDao")
    private UserDaoInter userDaoInter;

    @Override
    public UserDetails loadUserByUsername(String gmail) throws UsernameNotFoundException {
        User user=userDaoInter.getByGmail(gmail);
        if(user!=null){
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(gmail);

            builder.disabled(false);
            builder.password(user.getPassword());

            builder.authorities(getAuthoritiesList(user.getUserAuthorityList()))
                    .roles(getRolesList(user.getUserRoleList()));
            return builder.build();
        }else{
            throw new UsernameNotFoundException("User not found.");
        }
    }

    private String[] getAuthoritiesList(List<UserAuthority> userAuthorityList){
        String [] userAuthorities=new String[userAuthorityList.size()];
        int i=0;
        for (UserAuthority us:userAuthorityList){
                userAuthorities[i]=us.getAuthority().getAuthorityName();
           i++;
        }
        return userAuthorities;
    }

    private String[] getRolesList(List<UserRole> userRoleList){
        String [] userRoles=new String[userRoleList.size()];
        int i=0;
        for (UserRole ur:userRoleList){
            userRoles[i]=ur.getRole().getRoleName();
            i++;
        }
        return userRoles;
    }

}
