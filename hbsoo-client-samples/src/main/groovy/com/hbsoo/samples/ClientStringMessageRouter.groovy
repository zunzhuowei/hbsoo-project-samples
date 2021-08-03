package com.hbsoo.samples

import com.hbsoo.handler.message.router.adapter.StringMessageRouterAdapter
import com.hbsoo.msg.annotation.StrHandler
import com.hbsoo.msg.model.HBSMessage

/**
 * Created by zun.wei on 2021/8/2.
 *
 */
@StrHandler([0, 1])
class ClientStringMessageRouter extends StringMessageRouterAdapter {


    @Override
    protected HBSMessage<String> handler(int i, String s) {
        println "ClientStringMessageRouter ==::" + s
        return null
    }

}
