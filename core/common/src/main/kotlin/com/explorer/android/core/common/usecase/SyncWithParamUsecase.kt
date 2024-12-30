package com.explorer.android.core.common.usecase

interface SyncWithParamUsecase<P, R> : Usecase {
    operator fun invoke(param: P): R
}
