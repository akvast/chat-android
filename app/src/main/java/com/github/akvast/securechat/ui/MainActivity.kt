package com.github.akvast.securechat.ui

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.github.akvast.securechat.R
import com.github.akvast.securechat.databinding.ActivityMainBinding
import com.github.akvast.securechat.ui.adapter.DialogsAdapter
import com.github.akvast.securechat.ui.adapter.NavigationAdapter

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    var adapter = DialogsAdapter()

    var navigationAdapter = NavigationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.navigationRecyclerView.adapter = navigationAdapter
        binding.navigationRecyclerView.layoutManager = LinearLayoutManager(this)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, 0, 0)
        toggle.syncState()
    }

    override fun onResume() {
        super.onResume()
        adapter.reload()
        navigationAdapter.reload()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_search -> {
                startActivity(Intent(this, SearchActivity::class.java))
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

}