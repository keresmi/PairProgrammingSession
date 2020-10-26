package com.patrykserek.pairprogrammingsession.presentation

import androidx.recyclerview.widget.DiffUtil
import com.patrykserek.pairprogrammingsession.data.api.models.PriceBookItem

class PriceBookDiff : DiffUtil.ItemCallback<PriceBookItem>() {

    override fun areItemsTheSame(oldItem: PriceBookItem, newItem: PriceBookItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PriceBookItem, newItem: PriceBookItem): Boolean {
        return oldItem == newItem
    }
}