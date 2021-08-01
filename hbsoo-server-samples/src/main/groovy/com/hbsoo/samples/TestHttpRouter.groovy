package com.hbsoo.samples

import com.hbsoo.handler.message.router.adapter.HttpMessageRouterAdapter
import com.hbsoo.handler.message.router.model.HttpParam
import com.hbsoo.msg.annotation.HttpHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse

/**
 * Created by zun.wei on 2021/7/31.
 *
 */
@HttpHandler(value = ["", "/", "/index"])
class TestHttpRouter extends HttpMessageRouterAdapter {


    @Override
    protected DefaultFullHttpResponse handler(String uri, HttpParam param) {
        println param
        json("""{"result":"ok0000","success": true}""")
    }

}
