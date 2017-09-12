package com.aragones.paul.dawanda.models

import android.net.Uri
import com.google.gson.annotations.SerializedName

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
                  @SerializedName("image_base_url") val imageBaseUrl: Uri)

