package com.patrykserek.pairprogrammingsession.data.api.models

data class PriceBookResponse(
    var page: Int,
    var pageSize: Int,
    var totalCount: Int,
    var hasMore: Boolean,
    var data: List<PriceBookItem>
)