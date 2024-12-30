package com.explorer.android.discovery.local.mapper

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.content.Intent
import com.explorer.android.discovery.domain.model.Device

@SuppressLint("MissingPermission")
fun Intent.mapToDevice(): Device? {
    val device = getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE) ?: return null
    return Device(
        name = device.name,
        address = device.address
    )
}

@SuppressLint("MissingPermission")
fun BluetoothDevice.mapToDomain(): Device {
    return Device(
        name = name,
        address = address
    )
}
