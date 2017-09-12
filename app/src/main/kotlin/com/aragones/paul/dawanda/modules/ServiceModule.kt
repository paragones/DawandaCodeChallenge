package com.aragones.paul.dawanda.modules

import android.app.Application
import com.aragones.paul.dawanda.image.IImageLoader
import com.aragones.paul.dawanda.image.PicasoImageLoader
import com.aragones.paul.dawanda.repositories.CategoryRepository
import com.aragones.paul.dawanda.repositories.CategoryRepositoryImpl
import com.aragones.paul.dawanda.rest.CategoryRest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    internal fun provideImageLoader(application: Application): IImageLoader = PicasoImageLoader(application)
}