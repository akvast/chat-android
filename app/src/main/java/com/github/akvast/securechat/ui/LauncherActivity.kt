package com.github.akvast.securechat.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.akvast.securechat.R

class LauncherActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        // TODO: Autologin

        startActivity(Intent(this, AuthActivity::class.java))
    }

}
