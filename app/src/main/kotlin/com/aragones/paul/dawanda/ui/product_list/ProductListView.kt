package com.aragones.paul.dawanda.ui.product_list

import com.aragones.paul.dawanda.models.Product

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/12/2017.
 */
interface ProductListView {
    fun hideLoading()
    fun displayProductList(productList: List<Product>)
    fun displayError()
}