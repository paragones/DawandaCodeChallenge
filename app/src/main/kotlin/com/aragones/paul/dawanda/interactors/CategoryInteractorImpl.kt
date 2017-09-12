package com.aragones.paul.dawanda.interactors

import com.aragones.paul.dawanda.models.Category
import com.aragones.paul.dawanda.repositories.CategoryRepository
import rx.Observable

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
class CategoryInteractorImpl(val categoryRepository: CategoryRepository) : CategoryInteractor {

    override fun categories(): Observable<List<Category>> = categoryRepository.categories()
}