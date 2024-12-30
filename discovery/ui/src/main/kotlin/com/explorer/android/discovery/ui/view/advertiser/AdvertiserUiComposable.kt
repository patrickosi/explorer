package com.explorer.android.discovery.ui.view.advertiser

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.explorer.android.discovery.ui.viewmodel.AdvertiserViewModel

@Composable
fun AdvertiserUiComposable(
    component: AdvertiserUi.Component,
    viewModelStoreOwner: ViewModelStoreOwner
) {
    val viewModel = viewModel(
        modelClass = AdvertiserViewModel::class.java,
        viewModelStoreOwner = viewModelStoreOwner,
        factory = component.viewModelFactory()
    )
    val state by viewModel.state.observeAsState()
    Box(
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state?.loading == true) {
                CircularProgressIndicator(modifier = Modifier.size(50.dp))
                Spacer(modifier = Modifier.height(16.dp))
            }
            Button(
                onClick = {
                    if (state?.loading == true) {
                        viewModel.stop() // Stop advertising
                    } else {
                        viewModel.start("UniqueIdentifier") // Start advertising
                    }
                }
            ) {
                Text(
                    text = if (state?.loading == true) "Go Offline" else "Go Online"
                )
            }
        }
    }
}