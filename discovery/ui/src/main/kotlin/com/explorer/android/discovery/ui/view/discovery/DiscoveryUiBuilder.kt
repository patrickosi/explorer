package com.explorer.android.discovery.ui.view.discovery

import android.content.Context
import com.explorer.android.core.ui.base.UiBuilder

class DiscoveryUiBuilder(
    private val dependency: DiscoveryUi
) : UiBuilder.Component<DiscoveryUi, DiscoveryUi.Component>() {
    override fun build(context: Context): DiscoveryUi.Component {
        return DaggerDiscoveryUi_Component.builder().discoveryUi(dependency).build()
    }
}
