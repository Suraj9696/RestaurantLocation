package com.example.codeassignment.domain.repository

import com.example.codeassignment.domain.model.DataItem
import com.example.codeassignment.domain.model.Location

/**
 * Abstract repository interface for data operations.
 * Keeps domain layer independent of data implementation.
 */
interface DataRepository {
    fun getData(location: Location): List<DataItem>
    fun saveSessionData(data: List<DataItem>)
    fun getSessionHistory(): List<DataItem>
}
