package com.ctrip.framework.apollo.portal.spi.secoo;

import com.ctrip.framework.apollo.portal.spi.SsoHeartbeatHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Portal页面如果长时间不刷新，登录信息会过期。通过此接口来刷新登录信息
 *
 * @author QIANGLU on 2019-08-22
 */
public class SecooSsoHeartbeatHandler implements SsoHeartbeatHandler {
    @Override
    public void doHeartbeat(HttpServletRequest request, HttpServletResponse response) {

    }
}