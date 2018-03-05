package com.github.akvast.securechat.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import com.github.akvast.securechat.CSearchAdapter
import com.github.akvast.securechat.R
import com.github.akvast.securechat.databinding.ActivitySearchBinding
import com.github.akvast.securechat.ui.adapter.SearchAdapter

class SearchActivity : BaseActivity() {

    lateinit var binding: ActivitySearchBinding

    val adapter = SearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivitySearchBinding>(
                this,
                R.layout.activity_search)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.queryEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(text: Editable?) {
                CSearchAdapter.instance().setSearchQuery(text.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

}