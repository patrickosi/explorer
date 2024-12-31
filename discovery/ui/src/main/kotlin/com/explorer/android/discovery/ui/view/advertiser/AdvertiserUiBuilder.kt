package com.explorer.android.discovery.ui.view.advertiser

import android.content.Context
import com.explorer.android.core.ui.base.UiBuilder

class AdvertiserUiBuilder(
    private val dependency: AdvertiserUi
) : UiBuilder.ComponentWithParam<AdvertiserUiParam, AdvertiserUi, AdvertiserUi.Component>() {
    override fun build(context: Context, args: AdvertiserUiParam): AdvertiserUi.Component {
        return DaggerAdvertiserUi_Component.builder().advertiserUi(dependency).param(args).build()
    }
}
