package com.explorer.core.ui.extention

import com.explorer.core.ui.base.UiBuilder
import com.explorer.core.ui.base.UiComponent

fun<T, B : UiBuilder> UiComponent<T>.builder(clazz: Class<B>): B {
    return factory().builder(clazz)
}
