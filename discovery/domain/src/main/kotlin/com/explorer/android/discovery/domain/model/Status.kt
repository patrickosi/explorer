package com.explorer.android.discovery.domain.model

sealed interface Status {
    data object Idle: Status

    data object Active: Status

    data class Error(val error: Throwable): Status
}
