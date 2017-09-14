package com.aragones.paul.dawanda.modules

import android.app.Application
import com.aragones.paul.dawanda.image.ImageLoader
import com.aragones.paul.dawanda.image.PicasoImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    internal fun provideImageLoader(application: Application): ImageLoader = PicasoImageLoader(application)
}