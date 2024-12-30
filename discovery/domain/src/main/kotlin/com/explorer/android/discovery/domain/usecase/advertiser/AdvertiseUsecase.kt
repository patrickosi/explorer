package com.explorer.android.discovery.domain.usecase.advertiser

import com.explorer.android.core.common.usecase.SyncWithParamUsecase
import com.explorer.android.discovery.domain.repository.AdvertiserRepository
import javax.inject.Inject

class AdvertiseUsecase @Inject constructor(
    private val repository: AdvertiserRepository
) : SyncWithParamUsecase<String, Unit> {
    override fun invoke(param: String) {
        repository.start(param)
    }
}
