package com.aragones.paul.dawanda.repositories

import com.aragones.paul.dawanda.models.Category
import com.aragones.paul.dawanda.rest.CategoryRest
import rx.Observable
import rx.schedulers.Schedulers

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
class CategoryRepositoryImpl(val categoryRest: CategoryRest) : CategoryRepository {

    override fun categories(): Observable<List<Category>> {
        return categoryRest.categories()
                .subscribeOn(Schedulers.io())
    }
}