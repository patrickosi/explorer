package com.explorer.android.discovery.domain.usecase.search

import com.explorer.android.core.common.usecase.SyncUsecase
import com.explorer.android.discovery.domain.repository.ConsumerRepository
import javax.inject.Inject

class StopConsumerUsecase @Inject constructor(
    private val repository: ConsumerRepository
) : SyncUsecase<Unit> {
    override fun invoke() {
        repository.stop()
    }
}
