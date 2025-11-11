package com.example.codeassignment.domain.usecase

import com.example.codeassignment.domain.model.DataItem
import com.example.codeassignment.domain.repository.DataRepository

/**
 * Use case to save filtered data to in-memory storage.
 */
class SaveDataUseCase(private val repository: DataRepository) {
    operator fun invoke(data: List<DataItem>) = repository.saveSessionData(data)
}
