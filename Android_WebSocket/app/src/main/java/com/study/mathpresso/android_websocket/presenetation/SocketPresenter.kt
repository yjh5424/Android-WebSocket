package com.study.mathpresso.android_websocket.presenetation

import com.study.mathpresso.android_websocket.base.BasePresenter
import okhttp3.*
import okio.ByteString


class SocketPresenter : SocketContract.Presenter, BasePresenter<SocketContract.View>() {

    override fun initWebSocket(webSocketListener: WebSocketListener) {
        var client = OkHttpClient()
        var request = Request.Builder().url("server URL").build()

        client.newWebSocket(request,webSocketListener)
        client.dispatcher().executorService().shutdown()

    }

}