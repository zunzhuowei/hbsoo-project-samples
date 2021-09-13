package com.hbsoo.hall.biz

import com.game.commons.enties.resp.LoginRespEntity
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
        LoginRespEntity loginRespEntity = new LoginRespEntity()
        loginRespEntity.result = "ok"
        def message = HBSMessageHolder.make(GameConstants.H2R.LOGIN, loginRespEntity)
        sendMsg(message)
    }

}
