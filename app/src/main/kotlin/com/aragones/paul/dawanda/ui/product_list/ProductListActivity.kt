package com.aragones.paul.dawanda.ui.product_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.aragones.paul.dawanda.R
import com.aragones.paul.dawanda.extension.gone
import com.aragones.paul.dawanda.extension.visible
import com.aragones.paul.dawanda.image.IImageLoader
import com.aragones.paul.dawanda.models.Product
import com.aragones.paul.dawanda.ui.base.BaseActivity
import com.aragones.paul.dawanda.ui.product_detail.ProductDetailActivity
import com.twotoasters.jazzylistview.effects.SlideInEffect
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener
import kotlinx.android.synthetic.main.activity_product_list.*
import javax.inject.Inject

class ProductListActivity : BaseActivity(), ProductListView {

    @Inject
    lateinit var presenter: ProductListPresenter

    @Inject
    lateinit var imageLoader: IImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        component().inject(this)
        setupView()
    }

    private fun setupView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getTitleName()
        presenter.attach(this)
        presenter.loadData(getCategoryId())
    }

    private fun getTitleName(): CharSequence? = intent.extras.getString(KEY_CATEGORY_NAME)

    private fun getCategoryId(): Int = intent.extras.getInt(KEY_CATEGORY_ID)

    override fun hideLoading() {
        progressCircle.gone()
        icon.gone()
    }

    override fun displayProductList(productList: List<Product>) {
        val TWO_COLUMNS = 2
        val staggeredLayoutManager = StaggeredGridLayoutManager(TWO_COLUMNS, StaggeredGridLayoutManager.VERTICAL)
        val productAdapter = ProductAdapter(productList,
                imageLoader,
                { openProductDetailActivity(it) })
        productRecyclerView.layoutManager = staggeredLayoutManager
        productRecyclerView.adapter = productAdapter
        val jazzyAnimation = JazzyRecyclerViewScrollListener()
        jazzyAnimation.setTransitionEffect(SlideInEffect())
        productRecyclerView.addOnScrollListener(jazzyAnimation)
        productRecyclerView.visible()
    }

    private fun openProductDetailActivity(product: Product) {
        startActivity(ProductDetailActivity.intent(this, product))
    }

    override fun displayError() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    companion object {
        val KEY_CATEGORY_ID = "KEY_CATEGORY_ID"
        val KEY_CATEGORY_NAME = "KEY_CATEGORY_NAME"

        fun intent(context: Context, categoryId: Int, categoryName: String): Intent {
            val intent = Intent(context, ProductListActivity::class.java)
            intent.putExtras(Bundle().apply {
                putInt(KEY_CATEGORY_ID, categoryId)
                putString(KEY_CATEGORY_NAME, categoryName)

            })
            return intent
        }
    }
}
