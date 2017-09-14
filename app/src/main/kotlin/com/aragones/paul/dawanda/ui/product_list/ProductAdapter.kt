package com.aragones.paul.dawanda.ui.product_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.aragones.paul.dawanda.R
import com.aragones.paul.dawanda.extension.concatenateAlphaAnimations
import com.aragones.paul.dawanda.extension.visible
import com.aragones.paul.dawanda.image.ImageLoader
import com.aragones.paul.dawanda.models.Product
import com.makeramen.roundedimageview.RoundedImageView

class ProductAdapter(private val products: List<Product>,
                     private val imageLoader: ImageLoader,
                     private val openProductDetailActivity: (product: Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.product_view, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productLayout: RelativeLayout = view.findViewById(R.id.rl_product) as RelativeLayout
        val productTitle: TextView = view.findViewById(R.id.product_title) as TextView
        val price: TextView = view.findViewById(R.id.price) as TextView
        val productImage: ImageView = view.findViewById(R.id.product_image) as ImageView
        val sellerLayout: RelativeLayout = view.findViewById(R.id.rl_seller) as RelativeLayout
        val sellerName: TextView = view.findViewById(R.id.seller_name) as TextView
        val sellerImage: RoundedImageView = view.findViewById(R.id.seller_image) as RoundedImageView
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productTitle.text = products[position].title
        holder.price.text = String.format("%d%c", (products[position].price.cents / 100),
                products[position].price.symbol)
        imageLoader.loadInto(products[position].productImage.productL,
                holder.productImage)
        holder.productLayout.setOnClickListener {
            openProductDetailActivity(products[position])
        }
        holder.sellerName.text = products[position].seller.username
        imageLoader.loadInto(products[position].seller.imageBaseUrl,
                holder.sellerImage)
        holder.sellerLayout.setOnClickListener {
            openProductDetailActivity(products[position])
        }
        concatenateAlphaAnimations(mutableListOf(holder.productLayout, holder.sellerLayout), 100, 1f)
        holder.productLayout.visible()
        holder.sellerLayout.visible()
    }

    override fun getItemCount(): Int = products.size
}