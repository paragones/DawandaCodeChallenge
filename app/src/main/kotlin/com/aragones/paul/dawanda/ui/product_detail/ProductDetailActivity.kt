package com.aragones.paul.dawanda.ui.product_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle

import com.aragones.paul.dawanda.R
import com.aragones.paul.dawanda.extension.concatenateAlphaAnimations
import com.aragones.paul.dawanda.extension.visible
import com.aragones.paul.dawanda.image.ImageLoader
import com.aragones.paul.dawanda.models.Product
import com.aragones.paul.dawanda.ui.base.BaseActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_product_detail.*
import kotlinx.android.synthetic.main.product_view.*
import javax.inject.Inject

class ProductDetailActivity : BaseActivity() {
    lateinit var product: Product

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        component().inject(this)
        extractBundles(savedInstanceState)
        setupView()
    }

    private fun extractBundles(savedInstanceState: Bundle?) {
        product = if (savedInstanceState != null) {
            savedInstanceState.getParcelable(KEY_PRODUCT)
        } else {
            intent.extras.getParcelable(KEY_PRODUCT)
        }
    }

    private fun setupView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getString(R.string.product_details)
        imageLoader.loadInto(product.productImage.big, productImage)
        imageLoader.loadInto(product.seller.imageBaseUrl, sellerImage)
        product.badge?.let {
            badge.primaryText = it
            badge.visible()
        }
        productName.text = product.title
        priceView.text = String.format("%d%c", (product.price.cents / 100),
                product.price.symbol)
        sellerName.text = product.seller.username
        shopName.text = product.shop.title
        rating.text = getString(R.string.rating, product.seller.rating)

        concatenateAlphaAnimations(mutableListOf(badge, productName, priceView, sellerImage, sellerName,
                shopName, rating, buttonBasket, uniqueView, priceView), 100, 1f)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putParcelable(KEY_PRODUCT, product)
        super.onSaveInstanceState(outState)
    }

    companion object {
        val KEY_PRODUCT = "KEY_PRODUCT"

        fun intent(context: Context, product: Product): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtras(Bundle().apply {
                putParcelable("KEY_PRODUCT", product)
            })
            return intent
        }
    }
}
