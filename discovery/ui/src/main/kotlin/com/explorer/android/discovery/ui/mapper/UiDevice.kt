package com.explorer.android.discovery.ui.mapper

import com.explorer.android.discovery.domain.model.Device
import com.explorer.android.discovery.ui.model.UiDevice

fun Device.mapToUi(): UiDevice {
    return UiDevice(
        name = name,
        address = address
    )
}
