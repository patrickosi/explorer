package com.explorer.android.discovery.ui.view.discovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.explorer.android.core.ui.base.UiBuilder
import com.explorer.android.core.ui.base.UiViewModelProvider
import com.explorer.android.discovery.ui.view.advertiser.AdvertiserUiBuilder
import com.explorer.android.discovery.ui.view.consumer.ConsumerUiBuilder
import com.explorer.android.discovery.ui.viewmodel.ConsumerViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [ DiscoveryUiModule.Provider::class ])
interface DiscoveryUiModule {
    @Binds
    @DiscoveryUi.Scope
    fun factory(factory: UiViewModelProvider.Factory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @DiscoveryUi.Scope
    @UiViewModelProvider.Bind(ConsumerViewModel::class)
    fun viewModel(viewModel: ConsumerViewModel): ViewModel

    @Module
    object Provider {
        @DiscoveryUi.Scope
        @Provides
        @IntoMap
        @UiBuilder.Bind(AdvertiserUiBuilder::class)
        fun provideAdvertiserUiBuilder(component: DiscoveryUi.Component): UiBuilder {
            return AdvertiserUiBuilder(component)
        }

        @DiscoveryUi.Scope
        @Provides
        @IntoMap
        @UiBuilder.Bind(ConsumerUiBuilder::class)
        fun provideConsumerUiBuilder(component: DiscoveryUi.Component): UiBuilder {
            return ConsumerUiBuilder(component)
        }
    }
}
