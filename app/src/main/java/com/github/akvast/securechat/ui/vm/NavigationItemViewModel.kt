package com.github.akvast.securechat.ui.vm

import android.view.View

data class NavigationItemViewModel(
        val icon: Int,
        val title: String,
        val action: (View) -> Unit) {

    fun performAction(view: View) = action(view)

}