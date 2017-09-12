package com.aragones.paul.dawanda.models

import android.net.Uri
import com.google.gson.annotations.SerializedName

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */

data class Product(@SerializedName("id") val id: Long,
                   @SerializedName("category_id") val categoryId: Int,
                   @SerializedName("slug") val slug: String,
                   @SerializedName("unit") val unit: String?,
                   @SerializedName("title") val title: String,
                   @SerializedName("price") val price: Price,
                   @SerializedName("undiscounted_price") val undiscountedPrice: Price,
                   @SerializedName("base_price") val basePrice: Price,
                   @SerializedName("badge") val badge: String?,
                   @SerializedName("sale_percentage") val salePercentage: String?,
                   @SerializedName("discounted") val discounted: Boolean?,
                   @SerializedName("sold_in_unit") val soldInUnit: Boolean,
                   @SerializedName("seller") val seller: Seller,
                   @SerializedName("shop") val shop: Shop,
                   @SerializedName("default_image") val productImage: ProductImage,
                   @SerializedName("pinned") val pinned: Boolean,
                   @SerializedName("customizable") val customizable: Boolean,
                   @SerializedName("campaigned") val campaigned: Boolean)