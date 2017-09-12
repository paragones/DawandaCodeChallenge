package com.aragones.paul.dawanda.ui.main

import com.aragones.paul.dawanda.models.Category

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
interface MainView {
    fun displayCategories(categories: List<Category>)
    fun displayError()
    fun hideLoading()
}