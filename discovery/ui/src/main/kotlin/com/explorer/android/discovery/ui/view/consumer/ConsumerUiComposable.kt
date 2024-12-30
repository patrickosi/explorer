package com.explorer.android.discovery.ui.view.consumer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.explorer.android.discovery.ui.model.UiDevice
import com.explorer.android.discovery.ui.view.discovery.DiscoveryUiDevice
import com.explorer.android.discovery.ui.viewmodel.ConsumerViewModel

@Composable
fun ConsumerUiComposable(
    component: ConsumerUi.Component,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    val viewModel = viewModel(
        modelClass = ConsumerViewModel::class.java,
        viewModelStoreOwner = viewModelStoreOwner,
        factory = component.viewModelFactory()
    )
    val state by viewModel.state.observeAsState()
    state?.devices?.run { ConsumerUiDevices(this) }
}

@Composable
fun ConsumerUiDevices(devices: List<UiDevice>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(devices.size) { device ->
            DiscoveryUiDevice(device = devices.get(device))
        }
    }
}
