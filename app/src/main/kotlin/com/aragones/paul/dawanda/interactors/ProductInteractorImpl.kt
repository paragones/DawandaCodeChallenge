package com.aragones.paul.dawanda.interactors

import com.aragones.paul.dawanda.models.Category
import com.aragones.paul.dawanda.models.Product
import com.aragones.paul.dawanda.repositories.CategoryRepository
import com.aragones.paul.dawanda.repositories.ProductRepository
import rx.Observable

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
class ProductInteractorImpl(val productRepository: ProductRepository) : ProductInteractor {

    override fun products(categoryId: Int): Observable<List<Product>> = productRepository.products(categoryId)
}