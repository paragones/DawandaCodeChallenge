package com.aragones.paul.dawanda.interactors

import com.aragones.paul.dawanda.models.Category
import com.aragones.paul.dawanda.models.Product
import rx.Observable

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
interface ProductInteractor {
    fun products(categoryId: Int): Observable<List<Product>>
}