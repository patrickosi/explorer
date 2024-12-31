package com.explorer.android.discovery.data.repository

import com.explorer.android.discovery.data.datasource.AdvertiserDatasource
import com.explorer.android.discovery.data.handler.AdvertiserHandler
import com.explorer.android.discovery.domain.model.Device
import com.explorer.android.discovery.domain.model.Status
import com.explorer.android.discovery.domain.repository.AdvertiserRepository
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class AdvertiserRepositoryDelegate @Inject constructor(
    private val handler: AdvertiserHandler,
    private val datasource: AdvertiserDatasource,
) : AdvertiserRepository {

    override fun start(identifier: String, name: String) {
        datasource.start(identifier, name)
    }

    override fun status(): SharedFlow<Status> = handler.status()

    override fun devices(): List<Device> {
        return datasource.devices()
    }

    override fun stop() {
        handler.reset()
        datasource.stop()
    }
}
