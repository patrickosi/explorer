package com.explorer.android.app.ui.main

import android.content.Context
import com.explorer.android.core.ui.base.UiBuilder

class MainUiBuilder(private val dependency: MainUi) : UiBuilder.Component<MainUi, MainUi.Component>() {
    override fun build(context: Context): MainUi.Component {
        return DaggerMainUi_Component.builder().mainUi(dependency).build()
    }
}
