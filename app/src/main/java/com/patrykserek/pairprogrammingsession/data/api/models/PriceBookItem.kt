package com.patrykserek.pairprogrammingsession.data.api.models

data class PriceBookItem(
    var id: Int,
    var name: String?,
    var price: Double
) {
    val thumbnailUrl: String
        get() = "https://picsum.photos/id/${id % 1000}/75/75"
}
