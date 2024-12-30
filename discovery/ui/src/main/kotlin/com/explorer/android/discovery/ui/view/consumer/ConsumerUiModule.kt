package com.explorer.android.discovery.ui.view.consumer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.explorer.android.core.ui.base.UiViewModelProvider
import com.explorer.android.discovery.ui.viewmodel.ConsumerViewModel
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
