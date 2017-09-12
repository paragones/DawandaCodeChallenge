package com.aragones.paul.dawanda.ui.product_list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import com.aragones.paul.dawanda.R
import com.aragones.paul.dawanda.extension.gone
import com.aragones.paul.dawanda.extension.visible
import com.aragones.paul.dawanda.image.IImageLoader
import com.aragones.paul.dawanda.models.Product
import com.aragones.paul.dawanda.ui.base.BaseActivity
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
        presenter.attach(this)
        presenter.loadData(getCategoryId())
    }

    private fun getCategoryId(): Int = intent.extras.getInt(KEY_CATEGORY_ID)

    override fun hideLoading() {
        progressCircle.gone()
        icon.gone()
        productRecyclerView.visible()
    }

    override fun displayProductList(productList: List<Product>) {
        val staggeredLayoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
        val mainAdapter = MainAdapter(categories,
                imageLoader,
                { openProductListActivity(it) })
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (mainAdapter.getItemViewType(position)) {
                    position.rem(3) -> return 2
                    else -> return 1
                }
            }
        }
        mainRecyclerView.layoutManager = gridLayoutManager
        mainRecyclerView.adapter = mainAdapter
    }

    override fun displayError() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

    companion object {
        val KEY_CATEGORY_ID = "KEY_CATEGORY_ID"

        fun intent(context: Context, categoryId: Int): Intent {
            val intent = Intent(context, ProductListActivity::class.java)
            intent.extras.putInt(KEY_CATEGORY_ID, categoryId)
            return intent
        }
    }
}
