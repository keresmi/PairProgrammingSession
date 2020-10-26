package com.patrykserek.pairprogrammingsession.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.patrykserek.pairprogrammingsession.R
import com.patrykserek.pairprogrammingsession.data.api.models.PriceBookItem
import kotlinx.android.synthetic.main.item_price_book.view.*

class MainAdapter(priceBookDiff: PriceBookDiff) :
    PagingDataAdapter<PriceBookItem, MainAdapter.PriceBookViewHolder>(priceBookDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceBookViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_price_book, parent, false)
        return PriceBookViewHolder(view)
    }


    override fun onBindViewHolder(holder: PriceBookViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class PriceBookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(priceBookItem: PriceBookItem) {
            with(priceBookItem) {
                name?.let { itemView.name.text = it }
                itemView.price.text = price.toString()
                Glide.with(itemView)
                    .load(thumbnailUrl)
                    .into(itemView.thumbnail)
            }
        }
    }
}