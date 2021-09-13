package com.hbsoo.samples

import com.alibaba.fastjson.JSON
import com.game.commons.enties.c2h.req.JoinRoomEntity
import com.game.commons.enties.c2h.resp.LoginRespEntity
import com.hbsoo.commons.GameConstants
import com.hbsoo.commons.HBSMessageHolder
import com.hbsoo.handler.message.router.adapter.StringMessageRouterAdapter
import com.hbsoo.msg.annotation.StrHandler

/**
 * Created by zun.wei on 2021/8/2.
 *
 */
@StrHandler([GameConstants.H2C.LOGIN])
class LoginMessageRouter extends StringMessageRouterAdapter {


    @Override
    protected void handler(int msgType, String content) {
        println "LoginMessageRouter ==::" + content
        def loginRespEntity = JSON.parseObject(content, LoginRespEntity.class)
        if ("ok" == loginRespEntity.result) {
            JoinRoomEntity joinRoomEntity = new JoinRoomEntity()
            joinRoomEntity.gameType = 1
            def message = HBSMessageHolder.make(GameConstants.C2H.JOIN_ROOM, joinRoomEntity)
            sendMsg(message)
        }
    }

}
