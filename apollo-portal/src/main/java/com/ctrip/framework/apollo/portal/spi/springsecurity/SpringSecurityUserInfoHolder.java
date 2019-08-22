package com.ctrip.framework.apollo.portal.spi.springsecurity;

import com.ctrip.framework.apollo.portal.entity.bo.UserInfo;
import com.ctrip.framework.apollo.portal.spi.UserInfoHolder;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Principal;

public class SpringSecurityUserInfoHolder implements UserInfoHolder {

    private ThreadLocal<String> defaultUser = new ThreadLocal<>();


    @Override
    public UserInfo getUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(StringUtils.isNotEmpty(defaultUser.get()) ? defaultUser.get() : getCurrentUsername());
        return userInfo;
    }

    private String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        if (principal instanceof Principal) {
            return ((Principal) principal).getName();
        }
        return String.valueOf(principal);
    }


    public void remove() {
        defaultUser.remove();
    }


    public void updateDefaultUser(String userId) {
        defaultUser.set(userId);
    }
}
