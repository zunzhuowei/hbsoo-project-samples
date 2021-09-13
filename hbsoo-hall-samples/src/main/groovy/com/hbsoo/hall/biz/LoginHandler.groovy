package com.hbsoo.hall.biz

import com.alibaba.fastjson.JSON
import com.game.commons.enties.c2h.req.LoginEntity
import com.game.commons.enties.c2h.resp.LoginRespEntity
import com.hbsoo.commons.GameConstants
import com.hbsoo.commons.HBSMessageHolder
import com.hbsoo.handler.message.router.adapter.StringMessageRouterAdapter
import com.hbsoo.msg.annotation.StrHandler

/**
 * Created by zun.wei on 2021/9/13.
 *
 */
@StrHandler([GameConstants.C2H.LOGIN])
class LoginHandler extends StringMessageRouterAdapter  {


    @Override
    protected void handler(int msgType, String content) {
        LoginEntity loginEntity = JSON.parseObject(content, LoginEntity.class)
        loginEntity.username
        loginEntity.password
        super.setAttr(channel, "playerId", 1L)

        LoginRespEntity loginRespEntity = new LoginRespEntity()
        loginRespEntity.result = "ok"
        def message = HBSMessageHolder.make(GameConstants.H2C.LOGIN, loginRespEntity)
        sendMsg(message)
    }

}
