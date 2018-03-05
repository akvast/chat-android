package com.github.akvast.securechat.ui.adapter

import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.github.akvast.mvvm.adapter.ViewModelAdapter
import com.github.akvast.securechat.*

class SearchAdapter : ViewModelAdapter() {

    private val adapter: CSearchAdapter = CSearchAdapter.instance()

    private val adapterListener: CAdapterListener

    init {
        sharedObject(this, BR.adapter)
        cell(CUserViewModel::class.java, R.layout.cell_search_user, BR.vm)

        adapterListener = object : CAdapterListener() {
            override fun onChanged() {
                items.clear()
                items.addAll(adapter.users)
                notifyDataSetChanged()
            }
        }

        adapter.base.setListener(adapterListener)
    }

    override fun reload(refreshLayout: SwipeRefreshLayout?) {

    }

    fun onUserSelected(view: View, viewModel: CUserViewModel) {

    }

}