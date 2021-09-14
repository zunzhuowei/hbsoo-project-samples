package com.hbsoo.room.game

import com.hbsoo.room.constants.RoomConstants
import com.hbsoo.room.game.data.Room

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantLock

/**
 * Created by zun.wei on 2021/9/14.
 *
 */
class RoomHolder {

    static ReentrantLock findRoomLock = new ReentrantLock()

    /**
     * key 玩家id，value 房间id
     */
    static final Map<Long, Long> playerRoomMapping = new ConcurrentHashMap<>()

    /**
     * key 房间id，value 房间
     */
    static final Map<Long, Room> rooms = new ConcurrentHashMap<>()

    /**
     * 获取玩家所在房间
     * @param playerId 玩家id
     * @return 房间
     */
    static Optional<Room> getRoomByPlayerId(Long playerId) {
        Long roomId = playerRoomMapping.get(playerId)
        if (Objects.nonNull(roomId)) {
            Room room = rooms.get(roomId)
            return Optional.ofNullable(room)
        }
        return Optional.empty()
    }

    /**
     * 查找房间，如果房间不存在则创建房间
     * @param gameType 房间游戏类型
     * @return 房间
     */
    static Room findRoom(int gameType) {
        def entry = rooms.find { it ->
            it.value.gameType == gameType && it.value.players.size() < RoomConstants.MAX_ROOM_PLAYERS
        }
        if (entry) {
            return entry.value
        }
        boolean b = findRoomLock.tryLock()
        if (b) {
            Room newRoom = new Room()
            newRoom.gameType = gameType
            newRoom.name = "roomName"
            newRoom.id = System.currentTimeMillis()
            rooms.put(newRoom.id, newRoom)
            findRoomLock.unlock()
            return newRoom
        }
        return findRoom(gameType)
    }


//    /**
//     * 获取玩家所在房间，如果玩家不在房间中，则加入房间；如果房间不存在，则创建房间
//     * @param playerId 玩家id
//     * @return 房间
//     */
//    static Room getJoinOrCreateRoomByPlayerId(Long playerId) {
//        Long roomId = playerRoomMapping.get(playerId)
//        if (Objects.nonNull(roomId)) {
//            Room room = rooms.get(roomId)
//            if (Objects.nonNull(room)) {
//                return room
//            }
//        }
//    }

}
