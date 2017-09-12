package com.aragones.paul.dawanda.repositories

import com.aragones.paul.dawanda.models.Category
import com.aragones.paul.dawanda.models.Product
import com.aragones.paul.dawanda.rest.CategoryRest
import com.aragones.paul.dawanda.rest.ProductRest
import rx.Observable
import rx.schedulers.Schedulers

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
class ProductRepositoryImpl(val productRest: ProductRest) : ProductRepository {

    override fun products(categoryId: Int): Observable<List<Product>> {
        return productRest.product(categoryId)
                .subscribeOn(Schedulers.io())
    }
}