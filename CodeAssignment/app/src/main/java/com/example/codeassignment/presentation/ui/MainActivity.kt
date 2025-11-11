package com.example.codeassignment.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.codeassignment.R
import com.example.codeassignment.domain.model.Location
import com.example.codeassignment.presentation.viewmodel.DataViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * The main Activity of the app.
 * Observes ViewModel LiveData and triggers updates based on simulated location changes.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // ViewModel automatically injected via Hilt
    private val viewModel: DataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.filteredData.observe(this, Observer { filtered ->
            println("Filtered results: $filtered")
        })

        // Observe session history
        viewModel.sessionHistory.observe(this, Observer { history ->
            println("Session history: $history")
        })

        // Simulate location update
        viewModel.onLocationUpdate(Location(57.7089, 11.9746))
    }
}