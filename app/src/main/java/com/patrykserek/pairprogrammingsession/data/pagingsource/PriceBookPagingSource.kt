package com.patrykserek.pairprogrammingsession.data.pagingsource

import androidx.paging.PagingSource
import com.patrykserek.pairprogrammingsession.data.api.ApiService
import com.patrykserek.pairprogrammingsession.data.api.models.PriceBookItem
import com.patrykserek.pairprogrammingsession.data.api.models.PriceBookResponse
import com.patrykserek.pairprogrammingsession.data.api.serviceApiKey

class PriceBookPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, PriceBookItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PriceBookItem> {
        return runCatching {
            val response = apiService.getPriceBooks(
                params.key ?: 1,
                params.loadSize,
                serviceApiKey
            )
            with(response) {
                LoadResult.Page(
                    data = data,
                    prevKey = null,
                    nextKey = getNextKey(this)
                )
            }
        }.getOrElse {
            LoadResult.Error(it)
        }
    }

    override val keyReuseSupported = true

    private fun getNextKey(response: PriceBookResponse): Int? = with(response) {
        return if (hasMore) page
        else null
    }
}