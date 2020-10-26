package com.patrykserek.pairprogrammingsession.di

import androidx.paging.PagingConfig
import com.patrykserek.pairprogrammingsession.data.api.models.Filter
import com.patrykserek.pairprogrammingsession.data.pagingsource.PriceBookPagingSource
import com.patrykserek.pairprogrammingsession.data.repository.PriceBookRepository
import com.patrykserek.pairprogrammingsession.data.repository.PriceBookRepositoryImpl
import com.patrykserek.pairprogrammingsession.presentation.MainAdapter
import com.patrykserek.pairprogrammingsession.presentation.MainViewModel
import com.patrykserek.pairprogrammingsession.presentation.PriceBookDiff
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureModule = module {
    factory { PriceBookPagingSource(get()) }
    factory { PagingConfig(20) }
    factory<PriceBookRepository> { PriceBookRepositoryImpl(get(), get()) }
    viewModel { MainViewModel(get()) }
    factory { MainAdapter(get()) }
    factory { PriceBookDiff() }
    factory { Filter() }
}