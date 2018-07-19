package com.lyd.kafka;

import com.lyd.kafka.provider.KafkaSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootKafkaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootKafkaApplication.class, args);
        KafkaSender sender = context.getBean(KafkaSender.class);


        for (int i = 0; i < 10 ; i++) {

            sender.send();

            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }
}
