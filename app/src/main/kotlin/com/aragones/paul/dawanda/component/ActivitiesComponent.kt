package com.aragones.paul.dawanda.component

import com.aragones.paul.dawanda.modules.*
import com.aragones.paul.dawanda.ui.main.MainActivity
import com.aragones.paul.dawanda.ui.product_detail.ProductDetailActivity
import com.aragones.paul.dawanda.ui.product_list.ProductListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class,
        ExecutorsModule::class,
        InteractorModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ServiceModule::class))
interface ActivitiesComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: ProductListActivity)
    fun inject(activity: ProductDetailActivity)
}