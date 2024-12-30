package com.explorer.android.discovery.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.explorer.android.discovery.domain.model.Device
import com.explorer.android.discovery.domain.model.Status
import com.explorer.android.discovery.domain.usecase.advertiser.ConnectedDevicesUsecase
import com.explorer.android.discovery.domain.usecase.advertiser.AdvertStatusUsecase
import com.explorer.android.discovery.domain.usecase.advertiser.AdvertiseUsecase
import com.explorer.android.discovery.domain.usecase.advertiser.CancelAdvertiserUsecase
import com.explorer.android.discovery.ui.mapper.mapToUi
import com.explorer.android.discovery.ui.model.UiDevice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

class AdvertiserViewModel @Inject constructor(
    private val advertiseUsecase: AdvertiseUsecase,
    private val connectedDevicesUsecase: ConnectedDevicesUsecase,
    private val advertStatusUsecase: AdvertStatusUsecase,
    private val cancelAdvertiserUsecase: CancelAdvertiserUsecase,
) : ViewModel() {
    private val devices = MutableStateFlow<List<UiDevice>>(emptyList())

    private val error = MutableStateFlow<Throwable?>(null)

    private val mutableState = MutableLiveData<State>()

    val state: LiveData<State> = mutableState

    init {
        viewModelScope.launch {
            combine(
                devices,
                advertStatusUsecase(),
                error,
            ) { devices, status, error ->
                State(
                    loading = status is Status.Active,
                    devices = devices,
                    error = error
                )
            }.collectLatest(mutableState::postValue)
        }
    }

    fun start(identifier: String) {
        viewModelScope.launch { advertiseUsecase(identifier) }
    }

    fun devices() {
        viewModelScope.launch { devices.tryEmit(connectedDevicesUsecase().map(Device::mapToUi)) }
    }

    fun stop() {
        viewModelScope.launch { cancelAdvertiserUsecase() }
    }

    data class State(
        val loading: Boolean = false,
        val devices: List<UiDevice> = listOf(),
        val error: Throwable? = null
    )
}
