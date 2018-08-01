package com.study.mathpresso.android_websocket.presenetation

import com.study.mathpresso.android_websocket.base.BaseView
import okhttp3.WebSocketListener

interface SocketContract{

    interface View : BaseView{
        fun output(txt : String)
    }

    interface Presenter{
        fun initWebSocket(webSocketListener: WebSocketListener)
    }


}