package com.example.codeassignment.data.source

import com.example.codeassignment.data.model.DataItemEntity

/**
 * Stores session data in memory. Cleared when app restarts.
 */
object InMemoryDataSource {
    private val session = mutableListOf<DataItemEntity>()

    fun save(data: List<DataItemEntity>) {
        session.addAll(data)
    }

    fun getAll(): List<DataItemEntity> = session.toList()
}
