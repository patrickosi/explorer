package com.explorer.android.app.module

import com.explorer.android.discovery.data.datasource.AdvertiserDatasource
import com.explorer.android.discovery.data.datasource.ConsumerDatasource
import com.explorer.android.discovery.local.datasource.AdvertiserDatasourceDelegate
import com.explorer.android.discovery.local.datasource.ConsumerDatasourceDelegate
import dagger.Binds
import dagger.Module

@Module
interface DatasourceModule {
    @Binds
    fun discoveryDatasource(delegate: AdvertiserDatasourceDelegate): AdvertiserDatasource

    @Binds
    fun searchDatasource(delegate: ConsumerDatasourceDelegate): ConsumerDatasource
}
