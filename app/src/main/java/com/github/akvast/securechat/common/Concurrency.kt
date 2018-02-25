package com.github.akvast.securechat.common

import android.os.Handler
import android.os.Looper
import com.github.akvast.securechat.CConcurrency
import com.github.akvast.securechat.CRunnable

class Concurrency : CConcurrency() {

    override fun startThread(name: String?, callback: CRunnable?) {
        Thread(Runnable { callback?.run() }).start()
    }

    override fun executeInUi(callback: CRunnable?) {
        Handler(Looper.getMainLooper()).post({ callback?.run() })
    }

}