package com.hbsoo.room.game.data

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by zun.wei on 2021/9/14.
 *
 */
class Room {

    Long id
    String name;
    int gameType

    Map<Long, Player> players = new ConcurrentHashMap<>()

}
