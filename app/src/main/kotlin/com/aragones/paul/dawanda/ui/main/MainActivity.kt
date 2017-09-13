package com.aragones.paul.dawanda.ui.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.aragones.paul.dawanda.R
import com.aragones.paul.dawanda.extension.gone
import com.aragones.paul.dawanda.extension.visible
import com.aragones.paul.dawanda.image.IImageLoader
import com.aragones.paul.dawanda.models.Category
import com.aragones.paul.dawanda.ui.base.BaseActivity
import com.aragones.paul.dawanda.ui.product_list.ProductListActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var imageLoader: IImageLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component().inject(this)
        setupView()
        title = getString(R.string.category_section)
    }

    private fun setupView() {
        presenter.attach(this)
        presenter.loadData()
    }

    override fun displayCategories(categories: List<Category>) {
        val TWO_ROWS = 2
        val TWO_SPAN = 2
        val ONE_SPAN = 1

        mainRecyclerView.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this, TWO_ROWS)
        val mainAdapter = MainAdapter(categories,
                imageLoader,
                { categoryId: Int, categoryName: String -> openProductListActivity(categoryId, categoryName) })
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                when (mainAdapter.getItemViewType(position)) {
                    position.rem(3) -> return TWO_SPAN
                    else -> return ONE_SPAN
                }
            }
        }
        mainRecyclerView.layoutManager = gridLayoutManager
        mainRecyclerView.adapter = mainAdapter
    }

    override fun hideLoading() {
        progressCircle.gone()
        icon.gone()
        mainRecyclerView.visible()
    }

    private fun openProductListActivity(categoryId: Int, categoryName: String) {
        startActivity(ProductListActivity.intent(this, categoryId, categoryName))
    }

    override fun displayError() = Toast.makeText(this, R.string.error_message, Toast.LENGTH_LONG).show()

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }

//    companion object {
//        lateinit var activitiesComponent: ActivitiesComponent
//    }
}
