package com.aragones.paul.dawanda.models

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * DawandaCodeChallenge
 *
 * Created by Paul Aragones on 9/12/2017.
 */
data class Shop(@SerializedName("id") val id: Long,
                @SerializedName("subdomain") val subDomain: String,
                @SerializedName("holiday_from") val holidayFrom: Date?,
                @SerializedName("holiday_to") val holidayTo: Date?,
                @SerializedName("title") val title: String,
                @SerializedName("auto_confirm") val autoConfirm: Boolean)