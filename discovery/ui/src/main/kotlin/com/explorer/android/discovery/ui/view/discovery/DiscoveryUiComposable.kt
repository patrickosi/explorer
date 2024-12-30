package com.explorer.android.discovery.ui.view.discovery

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.explorer.android.core.ui.extention.builder
import com.explorer.android.discovery.ui.model.UiDevice
import com.explorer.android.discovery.ui.view.advertiser.AdvertiserUiBuilder
import com.explorer.android.discovery.ui.view.advertiser.AdvertiserUiComposable
import com.explorer.android.discovery.ui.view.advertiser.AdvertiserUiParam
import com.explorer.android.discovery.ui.view.consumer.ConsumerUiBuilder
import com.explorer.android.discovery.ui.view.consumer.ConsumerUiComposable
import com.explorer.android.discovery.ui.viewmodel.ConsumerViewModel
import java.util.UUID

@Composable
fun DiscoveryUiComposer(
    component: DiscoveryUi.Component,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    val viewModel = viewModel(
        modelClass = ConsumerViewModel::class.java,
        viewModelStoreOwner = viewModelStoreOwner,
        factory = component.viewModelFactory()
    )
    val state by viewModel.state.observeAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DiscoveryUiHeader {
            AdvertiserUiComposable(
                component.builder(AdvertiserUiBuilder::class.java)
                    .build(LocalContext.current,
                        AdvertiserUiParam(UUID.randomUUID().toString())),
                viewModelStoreOwner
            )
        }
        DiscoveryUiController(
            loading = state?.loading == true,
            onStart = { viewModel.start() },
            onStop = { viewModel.stop() }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (state?.loading == true) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
        }
        state?.error?.let { error ->
            Text(
                text = "Error: ${error.message}",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        ConsumerUiComposable(
            component.builder(ConsumerUiBuilder::class.java)
                .build(LocalContext.current),
            viewModelStoreOwner
        )
    }
}

@Composable
fun DiscoveryUiHeader(content: @Composable () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Nearby Devices",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        content()
    }
}

@Composable
fun DiscoveryUiController(
    loading: Boolean,
    onStart: () -> Unit,
    onStop: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = onStart,
            enabled = !loading
        ) { Text(text = "Start") }
        Button(
            onClick = onStop,
            enabled = loading
        ) { Text(text = "Stop") }
    }
}

@Composable
fun DiscoveryUiDevice(device: UiDevice) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${device.name}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Address: ${device.address}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
