package com.example.codeassignment.data.repository

import com.example.codeassignment.data.mapper.DataMapper
import com.example.codeassignment.data.source.InMemoryDataSource
import com.example.codeassignment.data.source.MockApiDataSource
import com.example.codeassignment.domain.model.DataItem
import com.example.codeassignment.domain.model.Location
import com.example.codeassignment.domain.repository.DataRepository


/**
 * Implementation of the DataRepository interface.
 * Responsible for fetching and storing data using data sources.
 */
class DataRepositoryImpl : DataRepository {
    override fun getData(location: Location): List<DataItem> {
        val entities = MockApiDataSource.getNearby(location)
        return DataMapper.fromEntityList(entities)
    }

    override fun saveSessionData(data: List<DataItem>) {
        val entities = DataMapper.toEntityList(data)
        InMemoryDataSource.save(entities)
    }

    override fun getSessionHistory(): List<DataItem> {
        val entities = InMemoryDataSource.getAll()
        return DataMapper.fromEntityList(entities)
    }
}

