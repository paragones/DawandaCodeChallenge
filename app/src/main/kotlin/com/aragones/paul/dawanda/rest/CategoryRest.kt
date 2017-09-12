package com.aragones.paul.dawanda.rest

import com.aragones.paul.dawanda.models.Category
import retrofit2.http.GET
import rx.Observable

interface CategoryRest {
    @GET("third-party-public/categories.json")
    fun categories(): Observable<List<Category>>
}