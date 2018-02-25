package com.github.akvast.securechat.common

import android.os.Handler
import android.os.Looper
import com.github.akvast.securechat.CCallback
import com.github.akvast.securechat.CMultithreadSupport

class MultithreadSupport : CMultithreadSupport() {

    override fun startThread(name: String?, callback: CCallback?) {
        Thread(Runnable { callback?.execute() }).start()
    }

    override fun executeInUi(callback: CCallback?) {
        Handler(Looper.getMainLooper()).post({ callback?.execute() })
    }

}