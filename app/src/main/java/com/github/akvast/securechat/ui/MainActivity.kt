package com.github.akvast.securechat.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import com.github.akvast.securechat.CApp
import com.github.akvast.securechat.R
import com.github.akvast.securechat.databinding.ActivityMainBinding
import com.github.akvast.securechat.databinding.DialogAddDialogBinding
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_add -> {
                addDialog()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    fun addDialog() {
        val binding = DataBindingUtil.inflate<DialogAddDialogBinding>(layoutInflater,
                R.layout.dialog_add_dialog,
                null,
                false)

        val dialog = AlertDialog.Builder(this)
                .setView(binding.root)
                .show()

        binding.dialog = dialog
        binding.activity = this
    }

    fun addDialog(view: View, dialog: AlertDialog) {
        val userIdEditText = dialog.findViewById<EditText>(R.id.user_id_edit_text)
        val titleEditText = dialog.findViewById<EditText>(R.id.title_edit_text)

        CApp.instance().addDialog(
                Integer.parseInt(userIdEditText?.text.toString()).toLong(),
                titleEditText?.text.toString())

        adapter.reload()

        dialog.dismiss()
    }

}