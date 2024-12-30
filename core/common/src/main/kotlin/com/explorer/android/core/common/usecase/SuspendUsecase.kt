package com.explorer.android.core.common.usecase

interface SuspendUsecase<R> : Usecase {
    suspend operator fun invoke(): R
}
