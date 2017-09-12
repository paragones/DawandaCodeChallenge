package com.aragones.paul.dawanda.repositories

import com.aragones.paul.dawanda.models.Category
import rx.Observable

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
interface CategoryRepository {
    fun categories(): Observable<List<Category>>
}