package com.explorer.discovery.ui.view.discovery

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelStoreOwner
import com.explorer.core.ui.base.UiBuilder
import com.explorer.core.ui.extention.builder
import com.explorer.discovery.ui.view.advertiser.AdvertiserUiProvider
import com.explorer.discovery.ui.view.consumer.ConsumerUiProvider

@Composable
fun DiscoveryUiProvider(
    identifier: String?,
    factory: UiBuilder.FactoryProvider,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    DiscoveryUiComposer(
        factory.builder(DiscoveryUiBuilder::class.java)
            .build(LocalContext.current, DiscoveryUiParam(identifier)),
        viewModelStoreOwner
    )
}

@Composable
fun DiscoveryUiComposer(
    component: DiscoveryUi.Component,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    if (component.param().identifier == null) {
        ConsumerUiProvider(component, viewModelStoreOwner)
    } else {
        AdvertiserUiProvider(
            component.param().identifier!!,
            component,
            viewModelStoreOwner
        )
    }
}


