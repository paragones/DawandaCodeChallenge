package com.aragones.paul.dawanda.image

import android.net.Uri
import android.widget.ImageView

interface IImageLoader {
    fun loadInto(uri: Uri, view: ImageView)

    fun loadInto(resId: Int, view: ImageView)
}
