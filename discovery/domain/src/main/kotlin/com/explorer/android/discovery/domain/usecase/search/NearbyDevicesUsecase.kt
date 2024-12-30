package com.explorer.android.discovery.domain.usecase.search

import com.explorer.android.core.common.usecase.SyncUsecase
import com.explorer.android.discovery.domain.model.Device
import com.explorer.android.discovery.domain.repository.ConsumerRepository
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class NearbyDevicesUsecase @Inject constructor(
    private val repository: ConsumerRepository
) : SyncUsecase<SharedFlow<List<Device>>> {
    override fun invoke(): SharedFlow<List<Device>> {
        return repository.devices()
    }
}
