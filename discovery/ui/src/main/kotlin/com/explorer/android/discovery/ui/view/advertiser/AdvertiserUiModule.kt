package com.explorer.android.discovery.ui.view.advertiser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.explorer.android.core.ui.base.UiViewModelProvider
import com.explorer.android.discovery.ui.viewmodel.AdvertiserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface AdvertiserUiModule {
    @Binds
    @AdvertiserUi.Scope
    fun factory(factory: UiViewModelProvider.Factory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @AdvertiserUi.Scope
    @UiViewModelProvider.Bind(AdvertiserViewModel::class)
    fun viewModel(viewModel: AdvertiserViewModel): ViewModel
}