package com.github.akvast.securechat.utils

import android.content.Context
import android.util.TypedValue
import com.github.akvast.securechat.App
import java.io.File

object Util {

    fun dpToPx(dp: Float): Float {
        val resources = App.context.resources
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
    }

    fun dpToPx(context: Context, dp: Int): Int {
        // Get the screen's density scale
        val scale = context.resources.displayMetrics.density
        // Convert the dps to pixels, based on density scale
        return (dp * scale + 0.5f).toInt()
    }

    fun getCacheDir(subfolder: String): File {
        val context = App.context
        var cacheDir = context.externalCacheDir
        if (cacheDir == null)
            cacheDir = context.cacheDir

        val dir = File(cacheDir, subfolder)
        dir.mkdirs()

        return dir
    }

}