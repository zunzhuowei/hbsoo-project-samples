package com.hbsoo.room.handler


import com.game.commons.enties.h2r.req.JoinRoomReq
import com.game.commons.enties.h2r.resp.JoinRoomResp
import com.hbsoo.commons.GameConstants
import com.hbsoo.game.commons.ServerHolder
import com.hbsoo.game.commons.ServerType
import com.hbsoo.game.inner.InnerMessageInformer
import com.hbsoo.game.inner.InnerMessageProcessor
import com.hbsoo.game.inner.InnerProcessor
import com.hbsoo.room.constants.RoomConstants
import com.hbsoo.room.game.RoomHolder
import com.hbsoo.room.game.data.Player
import com.hbsoo.room.game.data.Room
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by zun.wei on 2021/9/13.
 *
 */
@InnerProcessor(GameConstants.H2R.JOIN_ROOM)
class H2RJoinRoomHandler implements InnerMessageProcessor<JoinRoomReq> {


    @Autowired
    private InnerMessageInformer messageInformer

    @Autowired
    private ServerHolder serverHolder

    @Override
    Class<JoinRoomReq> regMessage() {
        return JoinRoomReq.class
    }

    @Override
    void process(JoinRoomReq message) {
        println "H2RJoinRoomHandler message = $message"
        Optional<Room> roomOpt = RoomHolder.getRoomByPlayerId(message.playerId)
        Room room = roomOpt.orElseGet({
            return RoomHolder.findRoom(message.gameType)
        })
        Player player = new Player()
        player.id = message.playerId
        player.score = message.score
        player.nickname = message.username
        room.players.put(message.playerId, player)

        RoomHolder.playerRoomMapping.put(message.playerId, room.id)
        serverHolder.saveServerId(message.playerId, ServerType.ROOM)
        JoinRoomResp joinRoomResp = new JoinRoomResp()
        joinRoomResp.gameType = message.gameType
        joinRoomResp.roomId = room.id
        joinRoomResp.playerId = player.id
        messageInformer.send(ServerType.HALL, player.id, GameConstants.R2H.JOIN_ROOM, 1L, false, false, joinRoomResp)


    }

}
