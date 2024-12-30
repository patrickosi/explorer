package com.explorer.android.app

import android.app.Application
import com.explorer.android.core.ui.base.UiComponent

class ExplorerApplication : Application(), Explorer, UiComponent.Provider<Explorer.Component> {
    override val injector: Explorer.Component by lazy {
        ExplorerBuilder(this).build(this)
    }
}
