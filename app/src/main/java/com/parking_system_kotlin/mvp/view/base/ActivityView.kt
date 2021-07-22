package com.parking_system_kotlin.mvp.view.base

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {
    private var activityRef: WeakReference<Activity> = WeakReference(activity)

    val activity: Activity?
        get() = activityRef.get()

    val context: Context?
        get() = activity

    val fragmentManager: FragmentManager?
        get() = (activity as AppCompatActivity?)?.supportFragmentManager
}
