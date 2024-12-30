package com.explorer.android.core.ui.extention

import android.app.Activity
import com.explorer.android.core.ui.base.UiBuilder
import com.explorer.android.core.ui.base.UiComponent
import kotlin.reflect.KClass

fun <T : UiBuilder> Activity.findBuilder(clazz: KClass<T>): T {
    val dependency = application as UiComponent.Provider<*>
    return (dependency.injector as UiComponent<*>).factory()
        .builder(clazz.java)
}
