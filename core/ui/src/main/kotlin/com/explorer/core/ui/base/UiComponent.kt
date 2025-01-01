package com.explorer.core.ui.base

import dagger.android.AndroidInjector

interface UiComponent<T> : AndroidInjector<T>, UiBuilder.FactoryProvider {
    interface Provider<T> {
        val injector: T
    }
}
