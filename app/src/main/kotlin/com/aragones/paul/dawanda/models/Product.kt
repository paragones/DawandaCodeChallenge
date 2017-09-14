package com.aragones.paul.dawanda.models

import android.os.Parcel
import com.aragones.paul.dawanda.image.DefaultParcelable
import com.aragones.paul.dawanda.image.read
import com.aragones.paul.dawanda.image.write
import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
                   @SerializedName("campaigned") val campaigned: Boolean) : Serializable, DefaultParcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.write(id,
                categoryId,
                slug,
                unit,
                title,
                price,
                undiscountedPrice,
                basePrice,
                badge,
                salePercentage,
                discounted,
                soldInUnit,
                seller,
                shop,
                productImage,
                pinned,
                customizable,
                campaigned)
    }

    companion object {
        @JvmField val CREATOR = DefaultParcelable.generateCreator { Product(it.read(), it.read(), it.read(), it.read(), it.read(), it.read(),
                it.read(), it.read(), it.read(),it.read(), it.read(), it.read(), it.read(), it.read(), it.read(), it.read(), it.read(), it.read()) }
    }
}