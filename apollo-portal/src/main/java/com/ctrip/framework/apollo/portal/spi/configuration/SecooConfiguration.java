package com.ctrip.framework.apollo.portal.spi.configuration;


import com.ctrip.framework.apollo.portal.spi.SecooService;
import com.ctrip.framework.apollo.portal.spi.secoo.SecooMsgService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qianglu
 */
@Configuration
public class SecooConfiguration {


    @Bean
    public SecooService secooService() {
        return new SecooMsgService();
    }

}

