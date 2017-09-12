package com.aragones.paul.dawanda.rest

import com.aragones.paul.dawanda.models.Product
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface ProductRest {
    @GET("third-party-public/categories/{id}.json")
    fun product(@Path("id") id: Int): Observable<List<Product>>
}