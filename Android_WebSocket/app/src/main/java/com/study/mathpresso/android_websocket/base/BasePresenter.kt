package com.study.mathpresso.android_websocket.base



open class BasePresenter<V : BaseView>{


    var view : BaseView?= null

    fun attachView(view : BaseView){
        this.view=view
    }

    fun detachView(){
        view=null
    }
}