package com.hbsoo.room

import com.alibaba.fastjson.JSON
import com.game.commons.enties.h2r.req.JoinRoomReq
import com.game.commons.enties.h2r.resp.JoinRoomResp
import com.hbsoo.commons.GameConstants
import com.hbsoo.game.inner.InnerMessageProcessor
import com.hbsoo.game.inner.InnerProcessor
import com.hbsoo.game.room.msg.HallMessageInformer
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by zun.wei on 2021/9/13.
 *
 */
@InnerProcessor(GameConstants.H2R.JOIN_ROOM)
class JoinRoomHandler implements InnerMessageProcessor<JoinRoomReq> {


    @Autowired
    private HallMessageInformer hallMessageInformer

    @Override
    Class<JoinRoomReq> regMessage() {
        return JoinRoomReq.class
    }

    @Override
    void process(JoinRoomReq message) {
        println "JoinRoomHandler message = $message"
        JoinRoomResp joinRoomResp = new JoinRoomResp()
        joinRoomResp.playerId = 111L
        joinRoomResp.score++

        String s = JSON.toJSONString(joinRoomResp)
        hallMessageInformer.send(GameConstants.R2H.JOIN_ROOM, s)

    }

}
