package com.explorer.core.ui.base

interface UiInteractor<T> {
    operator fun invoke(component: T)
}
