package com.github.akvast.securechat

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.github.akvast.securechat.common.MultithreadSupport

class App : Application() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        init {
            System.loadLibrary("native")
        }

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        val app = CApp.instance()

        app.setMultithreadSupport(MultithreadSupport())
        app.connect("192.168.1.2", 8080)
    }

}