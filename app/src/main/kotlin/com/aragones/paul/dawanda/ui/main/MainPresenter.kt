package com.aragones.paul.dawanda.ui.main

import com.aragones.paul.dawanda.schedulers.ThreadScheduler
import com.aragones.paul.dawanda.interactors.CategoryInteractor
import com.aragones.paul.dawanda.ui.base.BasePresenter
import javax.inject.Inject

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
class MainPresenter @Inject constructor(private val interactor: CategoryInteractor,
                                        scheduler: ThreadScheduler) : BasePresenter<MainView>(scheduler) {

    fun loadData() {
        interactor.categories()
                .compose(observeOn())
                .subscribe({
                    view?.hideLoading()
                    view?.displayCategories(it)
                }, {
                    view?.hideLoading()
                    view?.displayError()
                })
    }

}