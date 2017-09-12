package com.aragones.paul.dawanda.ui.product_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.aragones.paul.dawanda.R
import com.aragones.paul.dawanda.image.IImageLoader
import com.aragones.paul.dawanda.models.Product

class ProductAdapter(private val products: List<Product>,
                     private val imageLoader: IImageLoader,
                     private val openProductDetailActivity: (position: Int) -> Unit) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.product_view, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productLayout: RelativeLayout = view.findViewById(R.id.rl_product)
        val productTitle: TextView = view.findViewById(R.id.product_title)
        val price: TextView = view.findViewById(R.id.price)
        val productImage: ImageView = view.findViewById(R.id.product_image)
        val sellerLayout: RelativeLayout = view.findViewById(R.id.rl_seller)
        val sellerName: TextView = view.findViewById(R.id.seller_name)
        val sellerImage: ImageView = view.findViewById(R.id.seller_image)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productTitle.text = products[position].name
        imageLoader.loadInto(categories[position].imageUrl, holder.imageBackground)
        holder.cardView.setOnClickListener {
            openProductListActivity(categories[position].id)
        }
    }

    override fun getItemCount(): Int = categories.size
}