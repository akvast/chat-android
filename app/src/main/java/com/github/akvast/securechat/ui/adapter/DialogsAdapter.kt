package com.github.akvast.securechat.ui.adapter

import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.github.akvast.mvvm.adapter.ViewModelAdapter
import com.github.akvast.securechat.*
import com.github.akvast.securechat.ui.DialogActivity

class DialogsAdapter : ViewModelAdapter() {

    private var adapter = CDialogsAdapter.instance()
    private val adapterListener: CAdapterListener

    init {
        sharedObject(this, BR.adapter)
        cell(CDialogViewModel::class.java, R.layout.cell_dialog, BR.vm)

        adapterListener = object : CAdapterListener() {
            override fun onChanged() {
                items.clear()
                items.addAll(adapter.dialogs)
                notifyDataSetChanged()
            }
        }

        adapter.base.setListener(adapterListener)
    }

    override fun reload(refreshLayout: SwipeRefreshLayout?) {
        adapter.base.reload()
    }

    fun onDialogSelected(view: View, viewModel: CDialogViewModel) {
        val context = view.context

        context.startActivity(DialogActivity.makeIntent(context, viewModel))
    }

}