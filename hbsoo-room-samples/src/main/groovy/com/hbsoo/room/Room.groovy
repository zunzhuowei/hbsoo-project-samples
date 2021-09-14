package com.hbsoo.room

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by zun.wei on 2021/9/14.
 *
 */
class Room {

    Long id
    String name;

    Map<Long, Player> players = new ConcurrentHashMap<>()

}
