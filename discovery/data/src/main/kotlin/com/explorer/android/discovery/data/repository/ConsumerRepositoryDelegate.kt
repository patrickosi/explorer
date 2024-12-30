package com.explorer.android.discovery.data.repository

import com.explorer.android.discovery.data.datasource.ConsumerDatasource
import com.explorer.android.discovery.data.handler.ConsumerHandler
import com.explorer.android.discovery.domain.model.Device
import com.explorer.android.discovery.domain.model.Status
import com.explorer.android.discovery.domain.repository.ConsumerRepository
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class ConsumerRepositoryDelegate @Inject constructor(
    private val handler: ConsumerHandler,
    private val datasource: ConsumerDatasource,
) : ConsumerRepository {
    override fun start() {
        handler.onStart()
        datasource.start()
    }

    override fun status(): SharedFlow<Status> = handler.status()

    override fun devices(): SharedFlow<List<Device>> = handler.devices()

    override fun stop() {
        handler.reset()
        datasource.stop()
    }
}