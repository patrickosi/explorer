package com.explorer.android.app.ui.main

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.explorer.android.core.ui.base.UiComponent
import com.explorer.android.core.ui.extention.findBuilder
import javax.inject.Inject

class MainUiActivity : ComponentActivity(), UiComponent.Provider<MainUi.Component> {
    @Inject
    internal lateinit var permissions: List<String>

    @Inject
    internal lateinit var factory: ViewModelProvider.Factory

    private lateinit var viewModel: MainUiViewModel

    override val injector: MainUi.Component by lazy {
        findBuilder(MainUiBuilder::class).build(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        injector.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[MainUiViewModel::class.java]
        setContent {
            MainUiComposable(
                component = injector,
                viewModelStoreOwner = this,
                permissions = permissions,
                onError = { openAppSettings() }
            )
        }
    }

    private fun openAppSettings() {
        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", packageName, null)
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}
