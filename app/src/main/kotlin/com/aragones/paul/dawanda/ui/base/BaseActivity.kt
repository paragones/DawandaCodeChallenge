package com.aragones.paul.dawanda.ui.base

import android.support.v7.app.AppCompatActivity
import com.aragones.paul.dawanda.component.ActivitiesComponent
import com.aragones.paul.dawanda.component.DaggerActivitiesComponent
import com.aragones.paul.dawanda.modules.*
import com.aragones.paul.dawanda.ui.main.MainActivity

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/13/2017.
 */
abstract class BaseActivity: AppCompatActivity() {

    protected fun component(): ActivitiesComponent {
        return DaggerActivitiesComponent.builder()
                .applicationModule(ApplicationModule(application))
                .executorsModule(ExecutorsModule())
                .interactorModule(InteractorModule())
                .networkModule(NetworkModule())
                .repositoryModule(RepositoryModule())
                .serviceModule(ServiceModule())
                .build()
    }

//    companion object {
//        lateinit var activitiesComponent: ActivitiesComponent
//    }
}