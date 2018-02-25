package com.github.akvast.securechat

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.github.akvast.securechat.common.Concurrency

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

        app.setConcurrency(Concurrency())

        app.setHost("192.168.1.2")
        app.setPort(8080)

        // TODO: Set saved email/password and try connect
    }

}