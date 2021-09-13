package com.hbsoo.samples;

import com.hbsoo.client.HbsooClient;
import com.hbsoo.commons.GameConstants;
import com.hbsoo.commons.HBSMessageHolder;
import com.game.commons.enties.req.LoginEntity;
import com.hbsoo.handler.constants.ClientProtocolType;
import com.hbsoo.msg.model.HBSMessage;
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
public class GameClientSamplesApplication {



    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(GameClientSamplesApplication.class, args);
        final HbsooClient hbsooClient = context.getBean(HbsooClient.class);
        Channel ch = hbsooClient.protocolType(ClientProtocolType.STRING)
                .connect("127.0.0.1", 5555);

        // 登录服务器
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUsername("zhangsan");
        loginEntity.setPassword("123456");
        final HBSMessage<String> message = HBSMessageHolder.make(GameConstants.C2H.LOGIN, loginEntity);
        ch.writeAndFlush(message);

        /*try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))){
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
                        *//*HBSMessage<String> message = new HBSMessage<>();
                        MsgHeader msgHeader = new StrMsgHeader();
                        msgHeader.setMsgLen(msg.getBytes().length);
                        msgHeader.setMsgType((short) 1);
                        message.setHeader(msgHeader).setContent(msg);
                        ch.writeAndFlush(message);*//*
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }*/
    }

}
