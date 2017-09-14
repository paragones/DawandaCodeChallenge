package com.aragones.paul.dawanda.models

import android.net.Uri
import android.os.Parcel
import com.aragones.paul.dawanda.image.DefaultParcelable
import com.aragones.paul.dawanda.image.read
import com.aragones.paul.dawanda.image.write
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/12/2017.
 */
data class ProductImage(@SerializedName("big") val big: Uri,
                        @SerializedName("thumb") val thumb: Uri,
                        @SerializedName("long") val long: Uri,
                        @SerializedName("product_l") val productL: Uri,
                        @SerializedName("full") val full: Uri,
                        @SerializedName("listview") val listview: Uri,
                        @SerializedName("listview_xs") val listviewXs: Uri,
                        @SerializedName("listview_s") val listviewS: Uri,
                        @SerializedName("listview_m") val listviewM: Uri,
                        @SerializedName("listview_l") val listviewL: Uri,
                        @SerializedName("pin") val pin: Uri,
                        @SerializedName("square_130") val square130: Uri): Serializable, DefaultParcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.write(big,
                thumb,
                long,
                productL,
                full,
                listview,
                listviewXs,
                listviewS,
                listviewM,
                listviewL,
                pin,
                square130)
    }

    companion object {
        @JvmField
        val CREATOR = DefaultParcelable.generateCreator {
            ProductImage(it.read(), it.read(), it.read(), it.read(), it.read(), it.read(),
                    it.read(), it.read(), it.read(), it.read(), it.read(), it.read())
        }
    }
}