package com.example.codeassignment.data.source

import com.example.codeassignment.data.model.DataItemEntity
import com.example.codeassignment.domain.model.DataItem
import com.example.codeassignment.domain.model.Location

/**
 * Simulated data source that would normally call an external API.
 */
object MockApiDataSource {
    fun getNearby(location: Location): List<DataItemEntity> = listOf(
        DataItemEntity("1", "Tesla Supercharger", "ChargingStation", 0.8),
        DataItemEntity("2", "Nordic Bistro", "Restaurant", 1.2),
        DataItemEntity("3", "QuickCharge", "ChargingStation", 0.5),
        DataItemEntity("4", "Sushi Corner", "Restaurant", 0.3)
    )
}

