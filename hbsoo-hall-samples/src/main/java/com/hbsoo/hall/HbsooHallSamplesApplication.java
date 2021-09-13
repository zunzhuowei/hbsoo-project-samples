package com.hbsoo.hall;

import com.hbsoo.handler.constants.ServerProtocolType;
import com.hbsoo.server.HbsooServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by zun.wei on 2021/9/13.
 */
@SpringBootApplication
public class HbsooHallSamplesApplication {

    public static void main(String[] args) throws InterruptedException {
        final ConfigurableApplicationContext context = SpringApplication.run(HbsooHallSamplesApplication.class, args);
        final HbsooServer hbsooServer = context.getBean(HbsooServer.class);
        hbsooServer.create(1, 2)
                .protocolType(ServerProtocolType.HTTP, ServerProtocolType.STRING)
                .start(5555);

    }

}
