package com.explorer.android.discovery.domain.usecase.search

import com.explorer.android.core.common.usecase.SyncWithParamUsecase
import com.explorer.android.discovery.domain.repository.ConsumerRepository
import javax.inject.Inject

class ConsumerUsecase @Inject constructor(
    private val repository: ConsumerRepository
) : SyncWithParamUsecase<String, Unit> {
    override fun invoke(param: String) {
        repository.start(param)
    }
}
