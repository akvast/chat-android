package com.github.akvast.securechat.ui.adapter

import android.content.Intent
import android.support.v4.widget.SwipeRefreshLayout
import android.view.View
import com.firebase.ui.auth.AuthUI
import com.github.akvast.mvvm.adapter.ViewModelAdapter
import com.github.akvast.securechat.BR
import com.github.akvast.securechat.R
import com.github.akvast.securechat.ui.LauncherActivity
import com.github.akvast.securechat.ui.vm.NavigationHeaderViewModel
import com.github.akvast.securechat.ui.vm.NavigationItemViewModel
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task


class NavigationAdapter : ViewModelAdapter() {

    private val headerViewModel = NavigationHeaderViewModel()

    init {
        sharedObject(this, BR.adapter)
        cell(NavigationHeaderViewModel::class.java, R.layout.cell_navigation_header, BR.vm)
        cell(NavigationItemViewModel::class.java, R.layout.cell_navigation_item, BR.vm)
    }

    override fun reload(refreshLayout: SwipeRefreshLayout?) {
        items.clear()
        items.add(headerViewModel)
        items.add(NavigationItemViewModel(R.drawable.ic_exit_to_app_black_24dp, "Logout", { logout(it) }))
        notifyDataSetChanged()
    }

    fun logout(view: View) {
        val context = view.context

        AuthUI.getInstance()
                .signOut(context)
                .addOnCompleteListener(object : OnCompleteListener<Void> {
                    override fun onComplete(task: Task<Void>) {
                        val intent = Intent(context, LauncherActivity::class.java)
                        context.startActivity(Intent.makeRestartActivityTask(intent.component))
                    }
                })
    }

}