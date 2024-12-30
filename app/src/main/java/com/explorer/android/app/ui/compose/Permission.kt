package com.explorer.android.app.ui.compose

import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
fun Permissions(
    permissions: List<String>,
    onGranted: () -> Unit,
    onError: (deniedPermissions: List<String>) -> Unit
) {
    val context = LocalContext.current
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val unGrantedPermissions by remember {
        mutableStateOf(
            permissions.filter {
                context.checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED
            }
        )
    }
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        val deniedPermissions = result.filterValues { !it }.keys.toList()
        if (deniedPermissions.isEmpty()) {
            onGranted()
        } else {
            onError(deniedPermissions)
        }
    }
    var hasPermission by remember { mutableStateOf(unGrantedPermissions.isNotEmpty()) }
    DisposableEffect(unGrantedPermissions) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                if (unGrantedPermissions.isNotEmpty() && hasPermission) {
                    hasPermission = false
                    permissionLauncher.launch(unGrantedPermissions.toTypedArray())
                } else if (unGrantedPermissions.isEmpty()) {
                    onGranted()
                } else {
                    hasPermission = true
                }
            }
        }
        lifecycle.addObserver(observer)
        onDispose { lifecycle.removeObserver(observer) }
    }
}
