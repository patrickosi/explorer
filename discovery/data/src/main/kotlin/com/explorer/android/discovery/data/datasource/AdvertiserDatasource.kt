package com.explorer.android.discovery.data.datasource

import com.explorer.android.discovery.domain.model.Device

interface AdvertiserDatasource {
    fun start(identifier: String)

    fun devices(): List<Device>

    fun stop()

    interface Listener {
        fun onStart()

        fun onError(code: Int)
    }
}
