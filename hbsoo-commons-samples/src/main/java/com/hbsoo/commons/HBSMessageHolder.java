package com.hbsoo.commons;

import com.alibaba.fastjson.JSON;
import com.hbsoo.msg.model.HBSMessage;
import com.hbsoo.msg.model.MsgHeader;
import com.hbsoo.msg.model.StrMsgHeader;

/**
 * Created by zun.wei on 2021/9/13.
 */
public final class HBSMessageHolder {

    public static HBSMessage<String> make(int msgType, String msg) {
        HBSMessage<String> message = new HBSMessage<>();
        MsgHeader msgHeader = new StrMsgHeader();
        msgHeader.setMsgLen(msg.getBytes().length);
        msgHeader.setMsgType((short) msgType);
        message.setHeader(msgHeader).setContent(msg);
        return message;
    }

    public static HBSMessage<String> make(int msgType, Object msg) {
        final String jsonString = JSON.toJSONString(msg);
        return make(msgType, jsonString);
    }
}
