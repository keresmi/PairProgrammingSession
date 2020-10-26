package com.patrykserek.pairprogrammingsession.data.repository

import androidx.paging.PagingData
import com.patrykserek.pairprogrammingsession.data.api.models.PriceBookItem
import kotlinx.coroutines.flow.Flow

interface PriceBookRepository {
    fun getPriceBooks(): Flow<PagingData<PriceBookItem>>
}