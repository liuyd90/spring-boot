package com.lyd.kafka.provider;


import com.alibaba.fastjson.JSONObject;
import com.lyd.kafka.beans.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg("消息体");
        message.setSendDate(new Date());
        String s = JSONObject.toJSONString(message);
        log.info("+++++++++++ message = {}",s);
        kafkaTemplate.send("dsd",s);
    }

}
