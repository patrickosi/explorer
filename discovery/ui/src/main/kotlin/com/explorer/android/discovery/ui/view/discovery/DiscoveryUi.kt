package com.explorer.android.discovery.ui.view.discovery

import com.explorer.android.core.ui.base.UiComponent
import com.explorer.android.core.ui.base.UiModule
import com.explorer.android.core.ui.base.UiViewModelProvider
import com.explorer.android.discovery.domain.repository.AdvertiserRepository
import com.explorer.android.discovery.domain.repository.ConsumerRepository
import com.explorer.android.discovery.ui.view.advertiser.AdvertiserUi
import com.explorer.android.discovery.ui.view.consumer.ConsumerUi

interface DiscoveryUi {
    fun advertiser(): AdvertiserRepository

    fun consumer(): ConsumerRepository

    @javax.inject.Scope
    @Retention(AnnotationRetention.RUNTIME)
    annotation class Scope

    @Scope
    @dagger.Component(
        dependencies = [ DiscoveryUi::class ],
        modules = [ UiModule::class, DiscoveryUiModule::class ]
    )
    interface Component : DiscoveryUi,
        UiComponent<DiscoveryUiInteractor>,
        AdvertiserUi,
        ConsumerUi,
        UiViewModelProvider
}
