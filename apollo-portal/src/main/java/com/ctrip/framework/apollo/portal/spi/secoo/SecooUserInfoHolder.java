package com.ctrip.framework.apollo.portal.spi.secoo;

import com.ctrip.framework.apollo.portal.entity.bo.UserInfo;
import com.ctrip.framework.apollo.portal.spi.UserInfoHolder;

/**
 * 获取当前登录用户信息，SSO一般都是把当前登录用户信息放在线程ThreadLocal上
 *
 * @author QIANGLU on 2019-08-22
 */
public class SecooUserInfoHolder implements UserInfoHolder {
    @Override
    public UserInfo getUser() {
        return null;
    }
}