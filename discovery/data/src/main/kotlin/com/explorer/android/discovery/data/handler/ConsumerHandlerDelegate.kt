package com.explorer.android.discovery.data.handler

import com.explorer.android.discovery.data.datasource.ConsumerDatasource
import com.explorer.android.discovery.data.exception.ConsumerException
import com.explorer.android.discovery.domain.model.Device
import com.explorer.android.discovery.domain.model.Status
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConsumerHandlerDelegate  @Inject constructor() : ConsumerHandler, ConsumerDatasource.Listener {
    private val deviceList = ConcurrentHashMap.newKeySet<Device>()

    private val status = MutableSharedFlow<Status>(replay = RELAY).apply { tryEmit(Status.Idle) }

    private val devices = MutableSharedFlow<List<Device>>(replay = RELAY).apply { tryEmit(listOf()) }

    override fun status(): SharedFlow<Status> = status

    override fun onStart() {
        status.tryEmit(Status.Active)
    }

    override fun devices(): SharedFlow<List<Device>> = devices

    override fun onDiscover(device: Device) {
        if (deviceList.add(device)) {
            devices.tryEmit(deviceList.toList())
        }
    }

    override fun onError(code: Int) {
        status.tryEmit(Status.Error(ConsumerException(code)))
    }

    override fun reset() {
        deviceList.clear()
        devices.tryEmit(deviceList.toList())
        status.tryEmit(Status.Idle)
    }

    private companion object {
        const val RELAY = 1
    }
}
