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
data class Seller(@SerializedName("id") val id: Int,
                  @SerializedName("username") val username: String,
                  @SerializedName("country") val country: String,
                  @SerializedName("platform") val platform: String,
                  @SerializedName("rating") val rating: Int,
                  @SerializedName("image_base_url") val imageBaseUrl: Uri): Serializable, DefaultParcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.write(id,
                username,
                country,
                platform,
                rating,
                imageBaseUrl)
    }

    companion object {
        @JvmField
        val CREATOR = DefaultParcelable.generateCreator {
            Seller(it.read(), it.read(), it.read(), it.read(), it.read(), it.read())
        }
    }
}

