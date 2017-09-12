package com.aragones.paul.dawanda.modules

import com.aragones.paul.dawanda.repositories.CategoryRepository
import com.aragones.paul.dawanda.repositories.CategoryRepositoryImpl
import com.aragones.paul.dawanda.repositories.ProductRepository
import com.aragones.paul.dawanda.repositories.ProductRepositoryImpl
import com.aragones.paul.dawanda.rest.CategoryRest
import com.aragones.paul.dawanda.rest.ProductRest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesCategoryRepository(rest: CategoryRest): CategoryRepository = CategoryRepositoryImpl(rest)

    @Provides
    @Singleton
    fun providesProductRepository(rest: ProductRest): ProductRepository = ProductRepositoryImpl(rest)
}