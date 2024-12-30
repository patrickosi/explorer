package com.explorer.android.app

import android.content.Context
import com.explorer.android.core.ui.base.UiBuilder

class ExplorerBuilder(
    private val dependency: Explorer
) : UiBuilder.Component<Explorer, Explorer.Component>() {
    override fun build(context: Context): Explorer.Component {
        return DaggerExplorer_Component.builder().explorer(dependency).build()
    }
}
