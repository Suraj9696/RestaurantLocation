package com.example.codeassignment.data.mapper

import com.example.codeassignment.data.model.DataItemEntity
import com.example.codeassignment.domain.model.DataItem


/**
 * Converts between domain model (DataItem) and data entity (DataItemEntity).
 */
object DataMapper {

    fun fromEntity(entity: DataItemEntity): DataItem {
        return DataItem(
            id = entity.id,
            name = entity.name,
            type = entity.type,
            distance = entity.distance
        )
    }

    fun toEntity(model: DataItem): DataItemEntity {
        return DataItemEntity(
            id = model.id,
            name = model.name,
            type = model.type,
            distance = model.distance
        )
    }

    fun fromEntityList(list: List<DataItemEntity>) = list.map { fromEntity(it) }

    fun toEntityList(list: List<DataItem>) = list.map { toEntity(it) }
}
