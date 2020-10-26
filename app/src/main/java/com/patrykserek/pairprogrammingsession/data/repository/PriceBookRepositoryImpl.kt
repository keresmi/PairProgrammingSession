package com.patrykserek.pairprogrammingsession.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.patrykserek.pairprogrammingsession.data.api.models.PriceBookItem
import com.patrykserek.pairprogrammingsession.data.pagingsource.PriceBookPagingSource
import kotlinx.coroutines.flow.Flow

class PriceBookRepositoryImpl(
    private val pagingConfig: PagingConfig,
    private val priceBookPagingSource: PriceBookPagingSource
) : PriceBookRepository {

    override fun getPriceBooks(): Flow<PagingData<PriceBookItem>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { priceBookPagingSource }
        ).flow
    }
}