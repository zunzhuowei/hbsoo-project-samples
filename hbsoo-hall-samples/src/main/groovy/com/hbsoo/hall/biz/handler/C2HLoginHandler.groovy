package com.hbsoo.hall.biz.handler

import com.alibaba.fastjson.JSON
import com.game.commons.enties.c2h.req.LoginEntityReq
import com.game.commons.enties.c2h.resp.LoginResp
import com.hbsoo.commons.GameConstants
import com.hbsoo.commons.HBSMessageHolder
import com.hbsoo.game.commons.ServerHolder
import com.hbsoo.game.commons.ServerType
import com.hbsoo.handler.message.router.adapter.StringMessageRouterAdapter
import com.hbsoo.msg.annotation.StrHandler
import com.hbsoo.server.manager.ServerChannelManager
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by zun.wei on 2021/9/13.
 *
 */
@StrHandler([GameConstants.C2H.LOGIN])
class C2HLoginHandler extends StringMessageRouterAdapter  {

    @Autowired
    private ServerHolder serverHolder

    @Override
    protected void handler(int msgType, String content) {
        LoginEntityReq loginEntity = JSON.parseObject(content, LoginEntityReq.class)
        loginEntity.username
        loginEntity.password
        setAttr(channel, "playerId", 1L)

        Long playerId = getAttr(channel, "playerId")
        serverHolder.saveServerId(playerId, ServerType.HALL)
        ServerChannelManager.regChannel(1L, channel)

        LoginResp loginRespEntity = new LoginResp()
        loginRespEntity.result = "ok"
        def message = HBSMessageHolder.make(GameConstants.H2C.LOGIN, loginRespEntity)
        sendMsg(message)
    }

}
