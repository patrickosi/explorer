package com.explorer.android.core.common.usecase

interface SuspendWithParamUsecase<P, R> : Usecase {
    suspend operator fun invoke(param: P): R
}
