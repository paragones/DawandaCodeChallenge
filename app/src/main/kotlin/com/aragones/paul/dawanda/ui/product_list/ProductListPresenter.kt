package com.aragones.paul.dawanda.ui.product_list

import com.aragones.paul.dawanda.interactors.ProductInteractor
import com.aragones.paul.dawanda.schedulers.ThreadScheduler
import com.aragones.paul.dawanda.ui.base.BasePresenter
import javax.inject.Inject

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/12/2017.
 */
class ProductListPresenter @Inject constructor(private val interactor: ProductInteractor,
                                               scheduler: ThreadScheduler) : BasePresenter<ProductListView>(scheduler) {

    fun loadData(categoryId: Int) {
        interactor.products(categoryId)
                .compose(observeOn())
                .subscribe({
                    view?.hideLoading()
                    view?.displayProductList(it)
                }, {
                    view?.hideLoading()
                    view?.displayError()
                })
    }
}