package com.explorer.android.discovery.ui.view.advertiser

import com.explorer.android.core.ui.base.UiComponent
import com.explorer.android.core.ui.base.UiModule
import com.explorer.android.core.ui.base.UiViewModelProvider
import com.explorer.android.discovery.domain.repository.AdvertiserRepository

interface AdvertiserUi {
    fun advertiser(): AdvertiserRepository

    @javax.inject.Scope
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Scope

    @Scope
    @dagger.Component(
        dependencies = [ AdvertiserUi::class ],
        modules = [ UiModule::class, AdvertiserUiModule::class ]
    )
    interface Component : AdvertiserUi, UiComponent<AdvertiserUi>, UiViewModelProvider
}