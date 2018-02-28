package com.github.akvast.securechat.ui.adapter

import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.github.akvast.mvvm.adapter.ViewModelAdapter
import com.github.akvast.securechat.BR
import com.github.akvast.securechat.CDialogViewModel
import com.github.akvast.securechat.CDialogsAdapter
import com.github.akvast.securechat.R
import com.github.akvast.securechat.ui.DialogActivity

class DialogsAdapter : ViewModelAdapter() {

    var adapter = CDialogsAdapter.instance();

    init {
        sharedObject(this, BR.adapter)
        cell(CDialogViewModel::class.java, R.layout.cell_dialog, BR.vm)
    }

    override fun reload(refreshLayout: SwipeRefreshLayout?) {
        items.clear()
        items.addAll(adapter.dialogs)
        notifyDataSetChanged()
    }

    fun onDialogSelected(view: View, viewModel: CDialogViewModel) {
        val context = view.context

        context.startActivity(DialogActivity.makeIntent(context, viewModel))
    }

}