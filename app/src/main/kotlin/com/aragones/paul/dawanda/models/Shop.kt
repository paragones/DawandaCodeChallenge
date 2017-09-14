package com.aragones.paul.dawanda.models

import android.os.Parcel
import com.aragones.paul.dawanda.image.DefaultParcelable
import com.aragones.paul.dawanda.image.read
import com.aragones.paul.dawanda.image.write
import com.google.gson.annotations.SerializedName
import java.io.Serializable
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
                @SerializedName("auto_confirm") val autoConfirm: Boolean): Serializable, DefaultParcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.write(id,
                subDomain,
                holidayFrom,
                holidayTo,
                title,
                autoConfirm)
    }

    companion object {
        @JvmField
        val CREATOR = DefaultParcelable.generateCreator {
            Shop(it.read(), it.read(), it.read(), it.read(), it.read(), it.read())
        }
    }
}