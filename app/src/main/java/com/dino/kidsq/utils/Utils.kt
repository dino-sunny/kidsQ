package com.dino.kidsq.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View

object Utils {
    /**
     * Make status bar transparent
     */
    public fun setStatusIconColors(activity: Activity, color: String) {
        activity.window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        activity.window?.statusBarColor = Color.parseColor(color)
    }
}