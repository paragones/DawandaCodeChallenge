package com.aragones.paul.dawanda.interactors

import com.aragones.paul.dawanda.models.Category
import rx.Observable

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */
interface CategoryInteractor {
    fun categories(): Observable<List<Category>>
}