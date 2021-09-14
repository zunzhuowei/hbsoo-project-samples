package com.hbsoo.samples

import com.alibaba.fastjson.JSON
import com.game.commons.enties.c2h.resp.LoginResp
import com.hbsoo.commons.GameConstants
import com.hbsoo.handler.message.router.adapter.StringMessageRouterAdapter
import com.hbsoo.msg.annotation.StrHandler

/**
 * Created by zun.wei on 2021/8/2.
 *
 */
@StrHandler([GameConstants.H2C.JOIN_ROOM])
class JoinRoomMessageRouter extends StringMessageRouterAdapter {


    @Override
    protected void handler(int msgType, String content) {
        println "JoinRoomMessageRouter ==::" + content
        def loginRespEntity = JSON.parseObject(content, LoginResp.class)

    }

}
