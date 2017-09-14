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
 * Created by Paul Aragones on 9/12/2017.
 */
data class Price(@SerializedName("currency") val currency: String,
        @SerializedName("symbol") val symbol: Char,
        @SerializedName("cents") val cents: Long) : Serializable, DefaultParcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.write(currency,
                symbol,
                cents)
    }

    companion object {
        @JvmField
        val CREATOR = DefaultParcelable.generateCreator {
            Price(it.read(), it.read(), it.read())
        }
    }
}