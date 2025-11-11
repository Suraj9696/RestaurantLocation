package com.example.codeassignment.domain.algorithms

import com.example.codeassignment.domain.model.DataItem

/**
 * Strategy interface for filtering data.
 * Each car model may use a different implementation.
 */
interface FilterAlgorithm {
    fun filter(data: List<DataItem>): List<DataItem>
}
