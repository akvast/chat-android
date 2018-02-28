package com.github.akvast.securechat.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.github.akvast.securechat.R
import com.github.akvast.securechat.databinding.ActivityMainBinding
import com.github.akvast.securechat.ui.adapter.DialogsAdapter

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    var adapter = DialogsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        adapter.reload()
    }

}