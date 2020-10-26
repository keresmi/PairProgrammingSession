package com.patrykserek.pairprogrammingsession.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.patrykserek.pairprogrammingsession.data.repository.PriceBookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class MainViewModel(
    private val repository: PriceBookRepository
) : ViewModel() {

    val priceBooks by lazy {
        repository.getPriceBooks()
            .flowOn(Dispatchers.IO)
            .cachedIn(viewModelScope)
            .asLiveData(viewModelScope.coroutineContext)
    }

}