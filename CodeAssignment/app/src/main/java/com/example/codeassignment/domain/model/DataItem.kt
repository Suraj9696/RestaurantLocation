package com.example.codeassignment.domain.model


/**
 * Represents a generic data item (e.g., restaurant, charger, etc.)
 * used in the domain layer for business logic.
 */
data class DataItem(
    val id: String,
    val name: String,
    val type: String,
    val distance: Double
)

