package com.study.mathpresso.android_websocket.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast


abstract class BaseActivity : AppCompatActivity() {

    abstract var presenter: BasePresenter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showToast(str : String){
        Toast.makeText(applicationContext,str,Toast.LENGTH_SHORT).show()
    }


}