package com.aragones.paul.dawanda.models

import android.net.Uri
import com.google.gson.annotations.SerializedName

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/11/2017.
 */

data class Category(@SerializedName("id") val id: Int,
                    @SerializedName("name") val name: String,
                    @SerializedName("image_url") val imageUrl: Uri)


