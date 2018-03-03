package com.github.akvast.securechat.ui

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.github.akvast.securechat.CDialogViewModel
import com.github.akvast.securechat.R
import com.github.akvast.securechat.databinding.ActivityDialogBinding

class DialogActivity : BaseActivity() {

    companion object {

        const val KEY_DIALOG_ID = "dialog_id"

        fun makeIntent(context: Context, viewModel: CDialogViewModel): Intent {
            return Intent(context, DialogActivity::class.java)
        }

    }

    lateinit var binding: ActivityDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityDialogBinding>(
                this,
                R.layout.activity_dialog)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}