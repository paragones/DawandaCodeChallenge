package com.aragones.paul.dawanda.ui.product_detail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.aragones.paul.dawanda.R
import com.aragones.paul.dawanda.models.Product
import com.aragones.paul.dawanda.ui.base.BaseActivity

class ProductDetailActivity : BaseActivity() {
    lateinit var product: Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        extractBundles(savedInstanceState)
    }

    private fun extractBundles(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            product = savedInstanceState.getSerializable(KEY_PRODUCT) as Product
        } else {
            product = intent.extras.getSerializable(KEY_PRODUCT) as Product
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putSerializable(KEY_PRODUCT, product)
        super.onSaveInstanceState(outState)
    }

    companion object {
        val KEY_PRODUCT = "KEY_PRODUCT"

        fun intent(context: Context, product: Product): Intent {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.putExtras(Bundle().apply {
                putSerializable("KEY_PRODUCT", product)

            })
            return intent
        }
    }
}
