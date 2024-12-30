package com.explorer.android.app.module

import com.explorer.android.discovery.data.datasource.ConsumerDatasource
import com.explorer.android.discovery.data.handler.ConsumerHandler
import com.explorer.android.discovery.data.handler.ConsumerHandlerDelegate
import com.explorer.android.discovery.data.repository.ConsumerRepositoryDelegate
import com.explorer.android.discovery.domain.repository.ConsumerRepository
import dagger.Binds
import dagger.Module

@Module
interface ConsumerModule {
    @Binds
    fun consumerHandler(delegate: ConsumerHandlerDelegate): ConsumerHandler

    @Binds
    fun consumerListener(delegate: ConsumerHandlerDelegate): ConsumerDatasource.Listener

    @Binds
    fun consumerRepository(delegate: ConsumerRepositoryDelegate): ConsumerRepository
}
