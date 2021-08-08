package com.hbsoo.samples;

import com.hbsoo.client.HbsooClient;
import com.hbsoo.handler.constants.ClientProtocolType;
import com.hbsoo.msg.model.HBSMessage;
import com.hbsoo.msg.model.MsgHeader;
import com.hbsoo.msg.model.StrMsgHeader;
import io.netty.channel.Channel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zun.wei on 2021/8/2.
 */
@SpringBootApplication
public class ClientSamplesApplication {



    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(ClientSamplesApplication.class, args);
        final HbsooClient hbsooClient = context.getBean(HbsooClient.class);
        Channel ch = hbsooClient.protocolType(ClientProtocolType.STRING)
                .connect("127.0.0.1", 7777);


        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))){
            while (true) {
                try {
                    String msg = console.readLine();
                    if (msg == null || msg.trim().equals("")) {
                        continue;
                    } else if ("bye".equals(msg.toLowerCase())) {

                        break;
                    } else if ("ping".equals(msg.toLowerCase())) {

                    } else if (msg.toLowerCase().startsWith("text")) {

                    } else {
                        HBSMessage<String> message = new HBSMessage<>();
                        MsgHeader msgHeader = new StrMsgHeader();
                        msgHeader.setMsgLen(msg.getBytes().length);
                        msgHeader.setMsgType((short) 1);
                        message.setHeader(msgHeader).setContent(msg);
                        ch.writeAndFlush(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }

}
