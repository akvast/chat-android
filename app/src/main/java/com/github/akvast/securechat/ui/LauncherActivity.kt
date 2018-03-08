package com.github.akvast.securechat.ui

import android.content.Intent
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.github.akvast.securechat.CApp
import com.github.akvast.securechat.R
import com.google.firebase.auth.FirebaseAuth
import java.util.*


class LauncherActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val providers = Arrays.asList(AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build())

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {

            val user = FirebaseAuth.getInstance().currentUser
            user?.getIdToken(false)
                    ?.addOnCompleteListener {

                        val app = CApp.instance()
                        app.setToken(it.result.token.toString())
                        app.setName(user.displayName)
                        app.setEmail(user.email)
                        app.setAvatarUrl(user.photoUrl.toString())

                        app.connect()

                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }

        } else {
            // TODO:
        }
    }

}
