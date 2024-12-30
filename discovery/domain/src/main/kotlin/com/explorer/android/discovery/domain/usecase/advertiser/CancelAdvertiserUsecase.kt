package com.explorer.android.discovery.domain.usecase.advertiser

import com.explorer.android.core.common.usecase.SyncUsecase
import com.explorer.android.discovery.domain.repository.AdvertiserRepository
import javax.inject.Inject

class CancelAdvertiserUsecase @Inject constructor(
    private val repository: AdvertiserRepository
) : SyncUsecase<Unit> {
    override fun invoke() {
        repository.stop()
    }
}
