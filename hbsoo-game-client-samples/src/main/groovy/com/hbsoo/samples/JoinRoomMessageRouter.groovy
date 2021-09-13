package com.hbsoo.samples

import com.alibaba.fastjson.JSON
import com.game.commons.enties.req.JoinRoomEntity
import com.game.commons.enties.resp.JoinRoomRespEntity
import com.game.commons.enties.resp.LoginRespEntity
import com.hbsoo.commons.GameConstants
import com.hbsoo.commons.HBSMessageHolder
import com.hbsoo.handler.message.router.adapter.StringMessageRouterAdapter
import com.hbsoo.msg.annotation.StrHandler

/**
 * Created by zun.wei on 2021/8/2.
 *
 */
@StrHandler([GameConstants.H2R.JOIN_ROOM])
class JoinRoomMessageRouter extends StringMessageRouterAdapter {


    @Override
    protected void handler(int msgType, String content) {
        println "JoinRoomMessageRouter ==::" + content
        def loginRespEntity = JSON.parseObject(content, LoginRespEntity.class)

    }

}
