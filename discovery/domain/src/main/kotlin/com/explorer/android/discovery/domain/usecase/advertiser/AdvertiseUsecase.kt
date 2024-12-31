package com.explorer.android.discovery.domain.usecase.advertiser

import com.explorer.android.core.common.usecase.SyncWithParamUsecase
import com.explorer.android.discovery.domain.repository.AdvertiserRepository
import javax.inject.Inject

class AdvertiseUsecase @Inject constructor(
    private val repository: AdvertiserRepository
) : SyncWithParamUsecase<AdvertiseUsecase.Param, Unit> {
    override fun invoke(param: Param) {
        repository.start(param.identifier, param.name)
    }

    data class Param(
        val identifier: String,
        val name: String,
    )
}
