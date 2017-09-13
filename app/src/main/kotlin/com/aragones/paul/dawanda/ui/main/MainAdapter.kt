package com.aragones.paul.dawanda.ui.main

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.aragones.paul.dawanda.R
import com.aragones.paul.dawanda.image.IImageLoader
import com.aragones.paul.dawanda.models.Category


class MainAdapter(private val categories: List<Category>,
                  private val imageLoader: IImageLoader,
                  private val openProductListActivity: (categoryId: Int, categoryName:String) -> Unit) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.category_view, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: RelativeLayout = view.findViewById(R.id.card_view)
        val categoryTitle: TextView = view.findViewById(R.id.category_title)
        val imageBackground: ImageView = view.findViewById(R.id.image_background)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryTitle.text = categories[position].name
        imageLoader.loadInto(categories[position].imageUrl, holder.imageBackground)
        holder.cardView.setOnClickListener {
            openProductListActivity(categories[position].id, categories[position].name)
        }
    }

    override fun getItemCount(): Int = categories.size
}