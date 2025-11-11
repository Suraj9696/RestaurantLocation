package com.example.codeassignment.data.model

/**
 * Entity representation of data in the data layer.
 * Mirrors API or local storage structure.
 */
data class DataItemEntity(
    val id: String,
    val name: String,
    val type: String,
    val distance: Double
)
