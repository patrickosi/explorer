package com.explorer.android.core.ui.base

import dagger.android.AndroidInjector

interface UiComponent<T> : AndroidInjector<T> {
    fun factory(): UiBuilder.Factory

    interface Provider<T> {
        val injector: T
    }
}
