package com.explorer.android.discovery.data.datasource

import com.explorer.android.discovery.domain.model.Device

interface ConsumerDatasource {
    fun start()

    fun stop()

    interface Listener {
        fun onDiscover(device: Device)

        fun onError(code: Int)
    }
}
