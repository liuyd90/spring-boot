package com.lyd.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * 使用springboot 的注解监听
 */
@Slf4j
@Component
public class KafkaReceiver {

    @KafkaListener(topics = {"dsd"})
    public void listen(ConsumerRecord<?,?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            log.info("-------------------record = "+record);
            log.info("-------------------message = "+message);
        }
    }

}
