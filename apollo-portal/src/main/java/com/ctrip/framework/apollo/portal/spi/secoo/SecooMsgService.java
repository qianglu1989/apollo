package com.ctrip.framework.apollo.portal.spi.secoo;

import com.ctrip.framework.apollo.portal.entity.bo.Email;
import com.ctrip.framework.apollo.portal.entity.bo.SecooBo;
import com.ctrip.framework.apollo.portal.spi.SecooService;


import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * @author qianglu
 */
public class SecooMsgService implements SecooService {

    private static final Logger logger = LoggerFactory.getLogger(SecooMsgService.class);


    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void sendMsg(SecooBo secooBo) {


        Gson gson = new Gson();
        logger.info("send kafka msg start.........");
        kafkaTemplate.send("configmsg", gson.toJson(secooBo));
        logger.info("send kafka msg end.........");
    }
}
