package com.hbsoo.room

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by zun.wei on 2021/9/14.
 *
 */
class RoomHolder {

    /**
     * key 玩家id，value 房间id
     */
    static final Map<Long, Long> playerRoomMapping = new ConcurrentHashMap<>()

    /**
     * key 房间id，value 房间
     */
    static final Map<Long, Room> rooms = new ConcurrentHashMap<>()


    static Optional<Room> getRoomByPlayerId(Long playerId) {
        Long roomId = playerRoomMapping.get(playerId)
        if (Objects.nonNull(roomId)) {
            Room room = rooms.get(roomId)
            Optional.ofNullable(room)
        }
        return Optional.empty()
    }

}
