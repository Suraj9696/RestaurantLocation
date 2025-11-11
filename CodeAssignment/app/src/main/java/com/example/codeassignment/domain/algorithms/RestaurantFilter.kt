package com.example.codeassignment.domain.algorithms

import com.example.codeassignment.domain.model.DataItem

/**
 * Example filter that only keeps restaurant items.
 */
class RestaurantFilter : FilterAlgorithm {
    override fun filter(data: List<DataItem>) = data.filter { it.type == "Restaurant" }
}
