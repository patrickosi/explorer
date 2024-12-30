package com.explorer.android.discovery.domain.usecase.search

import com.explorer.android.core.common.usecase.SyncUsecase
import com.explorer.android.discovery.domain.model.Status
import com.explorer.android.discovery.domain.repository.ConsumerRepository
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

class ConsumerStatusUsecase @Inject constructor(
    private val repository: ConsumerRepository
) : SyncUsecase<SharedFlow<Status>> {
    override fun invoke(): SharedFlow<Status> {
        return repository.status()
    }
}
