package com.example.codeassignment.domain.algorithms

import com.example.codeassignment.domain.model.DataItem

/**
 * Example filter that keeps items within 1 km of distance.
 */
class DistanceFilter : FilterAlgorithm {
    override fun filter(data: List<DataItem>) = data.filter { it.distance <= 1.0 }
}
