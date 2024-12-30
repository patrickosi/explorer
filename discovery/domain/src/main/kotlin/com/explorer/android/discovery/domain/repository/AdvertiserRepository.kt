package com.explorer.android.discovery.domain.repository

import com.explorer.android.discovery.domain.model.Device
import com.explorer.android.discovery.domain.model.Status
import kotlinx.coroutines.flow.SharedFlow

interface AdvertiserRepository {
    fun start(identifier: String)

    fun status(): SharedFlow<Status>

    fun devices(): List<Device>

    fun stop()
}
