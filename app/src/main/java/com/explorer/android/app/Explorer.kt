package com.explorer.android.app

import android.bluetooth.BluetoothManager
import android.content.Context
import com.explorer.android.app.ui.main.MainUi
import com.explorer.android.app.ui.main.MainUiBuilder
import com.explorer.android.core.ui.base.UiBuilder
import com.explorer.android.core.ui.base.UiComponent
import com.explorer.android.core.ui.base.UiModule
import com.explorer.android.app.module.AdvertiserModule
import com.explorer.android.app.module.ConsumerModule
import com.explorer.android.app.module.DatasourceModule
import com.explorer.android.app.module.FactoryModule
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Singleton

interface Explorer {
    fun getApplicationContext(): Context

    @Module
    object Provider {
        @Singleton
        @Provides
        @IntoMap
        @UiBuilder.Bind(MainUiBuilder::class)
        fun provideMainBuilder(component: Component): UiBuilder {
            return MainUiBuilder(component)
        }

        @Provides
        fun bluetoothManager(context: Context): BluetoothManager {
            return context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        }
    }

    @Singleton
    @dagger.Component(
        dependencies = [ Explorer::class ],
        modules = [
            AdvertiserModule::class,
            ConsumerModule::class,
            FactoryModule::class,
            DatasourceModule::class,
            UiModule::class,
            Provider::class,
        ]
    )
    interface Component : Explorer, MainUi, UiComponent<ExplorerApplication>
}
