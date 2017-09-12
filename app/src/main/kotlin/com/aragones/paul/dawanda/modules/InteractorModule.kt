package com.aragones.paul.dawanda.modules

import com.aragones.paul.dawanda.interactors.CategoryInteractor
import com.aragones.paul.dawanda.interactors.CategoryInteractorImpl
import com.aragones.paul.dawanda.interactors.ProductInteractor
import com.aragones.paul.dawanda.interactors.ProductInteractorImpl
import com.aragones.paul.dawanda.repositories.CategoryRepository
import com.aragones.paul.dawanda.repositories.ProductRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Provides
    @Singleton
    fun providesCategoryInteractor(repository: CategoryRepository): CategoryInteractor
            = CategoryInteractorImpl(repository)

    @Provides
    @Singleton
    fun providesProductInteractor(repository: ProductRepository): ProductInteractor
            = ProductInteractorImpl(repository)
}