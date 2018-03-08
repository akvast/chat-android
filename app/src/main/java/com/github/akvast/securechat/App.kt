package com.github.akvast.securechat

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.facebook.drawee.backends.pipeline.Fresco
import com.github.akvast.securechat.common.Concurrency
import com.github.akvast.securechat.utils.Util

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

        Fresco.initialize(this)

        val app = CApp.instance()

        app.setConcurrency(Concurrency())

        app.openDatabase(Util.getCacheDir("database").absolutePath + "/db")

        app.setHost("192.168.1.2")
        app.setPort(8080)

        // TODO: Set saved email/password and try connect
    }

}