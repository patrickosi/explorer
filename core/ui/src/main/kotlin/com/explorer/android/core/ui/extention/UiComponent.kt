package com.explorer.android.core.ui.extention

import com.explorer.android.core.ui.base.UiBuilder
import com.explorer.android.core.ui.base.UiComponent

fun<T, B : UiBuilder> UiComponent<T>.builder(clazz: Class<B>): B {
    return factory().builder(clazz)
}
