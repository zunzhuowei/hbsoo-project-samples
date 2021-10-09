package com.hbsoo.hall.biz.inner

import com.game.commons.enties.h2r.resp.JoinRoomResp
import com.hbsoo.commons.GameConstants
import com.hbsoo.commons.HBSMessageHolder
import com.hbsoo.game.inner.InnerMessageProcessor
import com.hbsoo.game.inner.InnerProcessor
import com.hbsoo.server.manager.ServerChannelManager

/**
 * Created by zun.wei on 2021/9/13.
 *
 */
@InnerProcessor(GameConstants.R2H.JOIN_ROOM)
class R2HJoinRoomProcessor implements InnerMessageProcessor<JoinRoomResp> {


    @Override
    Class<JoinRoomResp> regMessage() {
        return JoinRoomResp.class
    }

    @Override
    void process(JoinRoomResp message) {
        println "R2HJoinRoomProcessor message = $message"
        def message2 = HBSMessageHolder.make(GameConstants.H2C.JOIN_ROOM, message)
        ServerChannelManager.sendMsg(message.playerId, message2)

    }
}
