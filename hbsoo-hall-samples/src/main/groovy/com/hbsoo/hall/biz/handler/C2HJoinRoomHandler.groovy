package com.hbsoo.hall.biz.handler

import com.alibaba.fastjson.JSON
import com.game.commons.enties.h2r.req.JoinRoomReq
import com.hbsoo.commons.GameConstants
import com.hbsoo.game.hall.msg.RoomMessageInformer
import com.hbsoo.handler.message.router.adapter.StringMessageRouterAdapter
import com.hbsoo.msg.annotation.StrHandler
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by zun.wei on 2021/9/13.
 *
 */
@StrHandler([GameConstants.C2H.JOIN_ROOM])
class C2HJoinRoomHandler extends StringMessageRouterAdapter  {

    @Autowired
    private RoomMessageInformer roomMessageInformer

    @Override
    protected void handler(int msgType, String content) {
        com.game.commons.enties.c2h.req.JoinRoomReq joinRoomEntity = JSON.parseObject(content, com.game.commons.enties.c2h.req.JoinRoomReq.class)
        Long playerId = getAttr(channel, "playerId")

        JoinRoomReq joinRoomReq = new JoinRoomReq()
        joinRoomReq.gameType = joinRoomEntity.gameType
        joinRoomReq.username = "zhang san"
        joinRoomReq.score = 100L
        joinRoomReq.playerId = playerId

        roomMessageInformer.send(GameConstants.H2R.JOIN_ROOM, joinRoomReq)


        /*JoinRoomReq joinRoomReq = new JoinRoomReq()
        String s = JSON.toJSONString(joinRoomReq)
        roomMessageInformer.send(GameConstants.H2R.JOIN_ROOM, s)

        LoginRespEntity loginRespEntity = new LoginRespEntity()
        loginRespEntity.result = "ok"
        def message = HBSMessageHolder.make(GameConstants.H2C.JOIN_ROOM, loginRespEntity)
        sendMsg(message)*/
    }

}
