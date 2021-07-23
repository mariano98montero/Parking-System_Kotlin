package com.parking_system_kotlin.mvp.view.base

import android.content.Context
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

open class FragmentView(fragment: Fragment) {
    private var fragmentRef: WeakReference<Fragment> = WeakReference(fragment)

    val fragment: Fragment?
        get() = fragmentRef.get()

    val context: Context?
        get() = fragment?.context
}
