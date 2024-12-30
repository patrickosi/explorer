package com.explorer.android.core.ui.base

interface UiInteractor<T> {
    operator fun invoke(component: T)
}
