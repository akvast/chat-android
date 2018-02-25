package com.github.akvast.securechat.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.github.akvast.securechat.CApp
import com.github.akvast.securechat.R
import com.github.akvast.securechat.databinding.ActivityAuthBinding

class AuthActivity : BaseActivity() {

    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityAuthBinding>(
                this,
                R.layout.activity_auth)

        binding.activity = this
    }

    fun auth(view: View) {
        CApp.instance().auth(binding.emailEditText.text.toString(), binding.passwordEditText.text.toString())
    }

}