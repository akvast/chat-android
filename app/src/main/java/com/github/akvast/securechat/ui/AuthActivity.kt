package com.github.akvast.securechat.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import com.github.akvast.securechat.CApp
import com.github.akvast.securechat.CConnectionViewModel
import com.github.akvast.securechat.CViewModelListener
import com.github.akvast.securechat.R
import com.github.akvast.securechat.databinding.ActivityAuthBinding

class AuthActivity : BaseActivity() {

    lateinit var binding: ActivityAuthBinding

    val connectionViewModel = CConnectionViewModel.instance();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityAuthBinding>(
                this,
                R.layout.activity_auth)

        binding.activity = this
        binding.connectionVM = connectionViewModel

        connectionViewModel.base.addListener(viewModelListener)
    }

    fun auth(view: View) {
//        val app = CApp.instance()
//        app.setEmail(binding.emailEditText.text.toString())
//        app.setPassword(binding.passwordEditText.text.toString())
//        app.connect()
    }

    val viewModelListener = object : CViewModelListener() {
        override fun onChanged() {
            binding.invalidateAll()

            if (connectionViewModel.isConnected) {
                val intent = Intent(this@AuthActivity, MainActivity::class.java)
                startActivity(Intent.makeMainActivity(intent.component))
                finish()
            }
        }
    }

}