package com.aragones.paul.dawanda.modules

import affinitas.com.affinitaspersonalitytest.schedulers.ObserveOnScheduler
import com.aragones.paul.dawanda.schedulers.ThreadScheduler
import dagger.Module
import dagger.Provides
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class ExecutorsModule {
    private val postExecutionThread = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    fun provideObserveExecutor(): ThreadScheduler = ObserveOnScheduler(postExecutionThread)
}