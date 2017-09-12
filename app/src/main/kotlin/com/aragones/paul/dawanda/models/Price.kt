package com.aragones.paul.dawanda.models

import com.google.gson.annotations.SerializedName

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/12/2017.
 */
data class Price(@SerializedName("currency") val currency: String,
        @SerializedName("symbol") val symbol: Char,
        @SerializedName("cents") val cents: Long)