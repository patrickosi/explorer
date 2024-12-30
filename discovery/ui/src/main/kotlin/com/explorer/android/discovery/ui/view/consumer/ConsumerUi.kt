package com.explorer.android.discovery.ui.view.consumer

import com.explorer.android.core.ui.base.UiComponent
import com.explorer.android.core.ui.base.UiModule
import com.explorer.android.core.ui.base.UiViewModelProvider
import com.explorer.android.discovery.domain.repository.ConsumerRepository

interface ConsumerUi {
    fun consumer(): ConsumerRepository

    @javax.inject.Scope
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Scope

    @Scope
    @dagger.Component(
        dependencies = [ ConsumerUi::class ],
        modules = [ UiModule::class, ConsumerUiModule::class ]
    )
    interface Component : ConsumerUi, UiComponent<ConsumerUi>, UiViewModelProvider
}
