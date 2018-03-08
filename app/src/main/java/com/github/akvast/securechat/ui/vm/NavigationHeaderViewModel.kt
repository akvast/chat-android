package com.github.akvast.securechat.ui.vm

import com.google.firebase.auth.FirebaseAuth

class NavigationHeaderViewModel {

    fun getName() = FirebaseAuth.getInstance().currentUser?.displayName

    fun getEmail() = FirebaseAuth.getInstance().currentUser?.email

    fun getAvatar() = FirebaseAuth.getInstance().currentUser?.photoUrl.toString()

}