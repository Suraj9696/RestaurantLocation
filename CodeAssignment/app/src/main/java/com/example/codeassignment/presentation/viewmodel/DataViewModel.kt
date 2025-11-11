package com.example.codeassignment.presentation.viewmodel


import androidx.lifecycle.*
import com.example.codeassignment.domain.algorithms.DistanceFilter
import com.example.codeassignment.domain.algorithms.FilterAlgorithm
import com.example.codeassignment.domain.algorithms.RestaurantFilter
import com.example.codeassignment.domain.model.CarModel
import com.example.codeassignment.domain.model.DataItem
import com.example.codeassignment.domain.model.Location
import com.example.codeassignment.domain.repository.DataRepository
import com.example.codeassignment.domain.usecase.GetFilteredDataUseCase
import com.example.codeassignment.domain.usecase.SaveDataUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * ViewModel responsible for orchestrating data flow between domain and UI.
 * Uses LiveData to expose reactive updates to the Activity.
 */
@HiltViewModel
class DataViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {

    private lateinit var algorithm: FilterAlgorithm

    private val _filteredData = MutableLiveData<List<DataItem>>()
    val filteredData: LiveData<List<DataItem>> get() = _filteredData

    private val _sessionHistory = MutableLiveData<List<DataItem>>()
    val sessionHistory: LiveData<List<DataItem>> get() = _sessionHistory

    /**
     * Sets the car model and initializes the appropriate filtering algorithm.
     */
    fun setCarModel(carModel: CarModel) {
        algorithm = when (carModel) {
            CarModel.STANDARD -> RestaurantFilter()
            CarModel.PERFORMANCE -> DistanceFilter()
        }
    }

    /**
     * Fetches and filters data based on the car's location.
     * Saves filtered data for session history and updates LiveData observers.
     */
    fun onLocationUpdate(location: Location) {
        if (!::algorithm.isInitialized) {
            setCarModel(CarModel.STANDARD)
        }

        val getFilteredDataUseCase = GetFilteredDataUseCase(repository, algorithm)
        val saveDataUseCase = SaveDataUseCase(repository)

        val filtered = getFilteredDataUseCase(location)
        saveDataUseCase(filtered)

        _filteredData.postValue(filtered)
        _sessionHistory.postValue(repository.getSessionHistory())
    }
}


