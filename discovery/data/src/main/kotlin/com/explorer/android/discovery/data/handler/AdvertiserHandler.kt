package com.explorer.android.discovery.data.handler

import com.explorer.android.discovery.domain.model.Status
import kotlinx.coroutines.flow.SharedFlow

interface AdvertiserHandler {
    fun status(): SharedFlow<Status>

    fun reset()
}