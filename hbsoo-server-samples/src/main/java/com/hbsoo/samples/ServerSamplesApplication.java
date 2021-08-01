package com.hbsoo.samples;

import com.hbsoo.handler.constants.ServerProtocolType;
import com.hbsoo.server.HbsooServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by zun.wei on 2021/8/1.
 */
@SpringBootApplication
public class ServerSamplesApplication {

    public static void main(String[] args) throws InterruptedException {
        final ConfigurableApplicationContext context = SpringApplication.run(ServerSamplesApplication.class, args);
        final HbsooServer hbsooServer = context.getBean(HbsooServer.class);
        hbsooServer.create(1, 2)
                .protocolType(ServerProtocolType.HTTP)
                //.start(5152);
                .start(7777);

    }


}
