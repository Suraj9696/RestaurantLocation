package com.example.codeassignment.domain.usecase

import com.example.codeassignment.domain.algorithms.FilterAlgorithm
import com.example.codeassignment.domain.model.Location
import com.example.codeassignment.domain.repository.DataRepository

/**
 * Use case to get raw data from repository and filter it using a chosen algorithm.
 */
class GetFilteredDataUseCase(
    private val repository: DataRepository,
    private val filter: FilterAlgorithm
) {
    operator fun invoke(location: Location) =
        filter.filter(repository.getData(location))
}
