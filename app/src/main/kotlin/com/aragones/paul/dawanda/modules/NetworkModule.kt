package com.aragones.paul.dawanda.modules

import android.net.Uri
import com.aragones.paul.dawanda.BuildConfig
import com.aragones.paul.dawanda.rest.CategoryRest
import com.aragones.paul.dawanda.rest.ProductRest
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.google.gson.GsonBuilder
import com.google.gson.JsonParseException
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.JsonDeserializer
import java.lang.reflect.Type


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideCategoryRest(retrofit: Retrofit): CategoryRest = retrofit.create(CategoryRest::class.java)

    @Provides
    @Singleton
    fun provideProductRest(retrofit: Retrofit): ProductRest = retrofit.create(ProductRest::class.java)

    @Provides
    @Singleton
    fun provideDefaultRestAdapter(): Retrofit = defaultRetrofit().build()

    private fun defaultRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(defaultGson()))
    }

    private fun defaultGson(): Gson {
        return GsonBuilder()
                .registerTypeAdapter(Uri::class.java, UriDeserializer())
                .create()
    }

    class UriDeserializer : JsonDeserializer<Uri> {
        @Throws(JsonParseException::class)
        override fun deserialize(src: JsonElement, srcType: Type,
                                 context: JsonDeserializationContext): Uri = Uri.parse(String.format("http:%s",src.asString))
    }
}

