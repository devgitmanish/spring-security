package com.springsecurity.config;

import com.springsecurity.entity.UserInfo;
import com.springsecurity.respository.UserInfoRepositity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInformationLoadViaDB implements UserDetailsService {

    @Autowired
    private UserInfoRepositity userInfoRepositity;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> user = userInfoRepositity.findByUserName(username);

        return user.map(UserInfoToUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "user not found " + username));
    }
}
