package com.ctrip.framework.apollo.portal.spi.secoo;

import com.ctrip.framework.apollo.portal.entity.bo.UserInfo;
import com.ctrip.framework.apollo.portal.spi.UserService;

import java.util.List;

/**
 * Secoo统一登录平台
 *
 * @author QIANGLU on 2019-08-22
 */
public class SecooUserService implements UserService {
    @Override
    public List<UserInfo> searchUsers(String keyword, int offset, int limit) {
        return null;
    }

    @Override
    public UserInfo findByUserId(String userId) {
        return null;
    }

    @Override
    public List<UserInfo> findByUserIds(List<String> userIds) {
        return null;
    }
}