package com.explorer.android.app.module

import com.explorer.android.discovery.data.datasource.AdvertiserDatasource
import com.explorer.android.discovery.data.handler.AdvertiserHandler
import com.explorer.android.discovery.data.handler.AdvertiserHandlerDelegate
import com.explorer.android.discovery.data.repository.AdvertiserRepositoryDelegate
import com.explorer.android.discovery.domain.repository.AdvertiserRepository
import dagger.Binds
import dagger.Module

@Module
interface AdvertiserModule {
    @Binds
    fun advertiserHandler(delegate: AdvertiserHandlerDelegate): AdvertiserHandler

    @Binds
    fun advertiserListener(delegate: AdvertiserHandlerDelegate): AdvertiserDatasource.Listener

    @Binds
    fun advertiserRepository(delegate: AdvertiserRepositoryDelegate): AdvertiserRepository
}
