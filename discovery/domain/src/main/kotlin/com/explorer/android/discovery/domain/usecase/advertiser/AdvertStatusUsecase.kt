package com.explorer.android.discovery.domain.usecase.advertiser

import com.explorer.android.core.common.usecase.SyncUsecase
import com.explorer.android.discovery.domain.model.Status
import com.explorer.android.discovery.domain.repository.AdvertiserRepository
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class AdvertStatusUsecase @Inject constructor(
    private val repository: AdvertiserRepository
) : SyncUsecase<SharedFlow<Status>> {
    override fun invoke(): SharedFlow<Status> {
        return repository.status()
    }
}
