package com.aragones.paul.dawanda.image

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso

class PicasoImageLoader(context: Context) : IImageLoader {
    private val picasso: Picasso = Picasso.Builder(context).build()

    override fun loadInto(uri: Uri, view: ImageView) {
        picasso.load(uri)
                .into(view)
    }

    override fun loadInto(resId: Int, view: ImageView) {
        picasso.load(resId)
                .into(view)
    }
}
