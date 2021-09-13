package com.hbsoo.hall.biz

import com.alibaba.fastjson.JSON
import com.game.commons.enties.c2h.req.JoinRoomEntity
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
class JoinRoomHandler extends StringMessageRouterAdapter  {

    @Autowired
    private RoomMessageInformer roomMessageInformer

    @Override
    protected void handler(int msgType, String content) {
        JoinRoomEntity joinRoomEntity = JSON.parseObject(content, JoinRoomEntity.class)
        Long playerId = super.getAttr(channel, "playerId")

        JoinRoomReq joinRoomReq = new JoinRoomReq()
        joinRoomReq.gameType = joinRoomEntity.gameType
        joinRoomReq.username = ""
        joinRoomReq.score = 100L
        joinRoomReq.playerId = playerId

        String s = JSON.toJSONString(joinRoomReq)
        roomMessageInformer.send(GameConstants.H2R.JOIN_ROOM, s)


        /*JoinRoomReq joinRoomReq = new JoinRoomReq()
        String s = JSON.toJSONString(joinRoomReq)
        roomMessageInformer.send(GameConstants.H2R.JOIN_ROOM, s)

        LoginRespEntity loginRespEntity = new LoginRespEntity()
        loginRespEntity.result = "ok"
        def message = HBSMessageHolder.make(GameConstants.H2C.JOIN_ROOM, loginRespEntity)
        sendMsg(message)*/
    }

}
