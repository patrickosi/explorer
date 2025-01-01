package com.explorer.discovery.ui.view.consumer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.explorer.core.ui.base.UiViewModelProvider
import com.explorer.discovery.ui.viewmodel.ConsumerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ConsumerUiModule {
    @Binds
    @ConsumerUi.Scope
    fun factory(factory: UiViewModelProvider.Factory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ConsumerUi.Scope
    @UiViewModelProvider.Bind(ConsumerViewModel::class)
    fun viewModel(viewModel: ConsumerViewModel): ViewModel
}
