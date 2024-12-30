package com.explorer.android.core.common.usecase

interface SyncUsecase<R> : Usecase {
    operator fun invoke(): R
}
