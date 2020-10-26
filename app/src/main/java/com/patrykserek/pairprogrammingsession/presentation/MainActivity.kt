package com.patrykserek.pairprogrammingsession.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.patrykserek.pairprogrammingsession.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val adapter by inject<MainAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()
        observePriceBook()
    }

    private fun observePriceBook() {
        viewModel.priceBooks.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }

    private fun setupRecycler() {
        recyclerView.adapter = adapter
    }
}