package com.study.mathpresso.android_websocket

import android.os.Bundle
import com.study.mathpresso.android_websocket.base.BaseActivity
import com.study.mathpresso.android_websocket.base.BasePresenter
import com.study.mathpresso.android_websocket.presenetation.SocketContract
import com.study.mathpresso.android_websocket.presenetation.SocketPresenter
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Response
import okhttp3.WebSocket
import okio.ByteString

class MainActivity : BaseActivity(), SocketContract.View{

    override var presenter: BasePresenter<*> = SocketPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)
        init()
    }



    private fun init(){
        button_start.setOnClickListener {
            (presenter as SocketPresenter).initWebSocket(WebSocketListener())
        }
    }

    override fun output(txt: String) {
        runOnUiThread { text_output.text=text_output.text.toString()+"\n\n"+txt}
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onError() {
        showToast("Error")
    }

    inner class WebSocketListener : okhttp3.WebSocketListener(){
        override fun onOpen(webSocket: WebSocket?, response: Response?) {
            super.onOpen(webSocket, response)

            webSocket?.send("Hello Test")
            webSocket?.close(200,"END!")
        }

        override fun onFailure(webSocket: WebSocket?, t: Throwable?, response: Response?) {
            super.onFailure(webSocket, t, response)
            output("Error :" + t!!.message)
        }

        override fun onClosing(webSocket: WebSocket?, code: Int, reason: String?) {
            super.onClosing(webSocket, code, reason)
            webSocket?.close(200, null);
        }

        override fun onMessage(webSocket: WebSocket?, text: String?) {
            super.onMessage(webSocket, text)
            output(text!!)
        }

        override fun onMessage(webSocket: WebSocket?, bytes: ByteString?) {
            super.onMessage(webSocket, bytes)
            output("btye : " + bytes!!.hex())
        }

        override fun onClosed(webSocket: WebSocket?, code: Int, reason: String?) {
            super.onClosed(webSocket, code, reason)
        }

    }

}
