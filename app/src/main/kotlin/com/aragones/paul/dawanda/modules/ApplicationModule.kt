package com.aragones.paul.dawanda.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    internal fun provideApplication(): Application = application

    @Provides
    internal fun providesContext(): Context = application
}