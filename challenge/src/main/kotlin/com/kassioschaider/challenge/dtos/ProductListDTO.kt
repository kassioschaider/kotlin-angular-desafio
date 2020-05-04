package com.kassioschaider.challenge.dtos

import java.util.*

data class ProductListDTO (
        val productId: String? = null,
        val title: String,
        val type: String,
        val price: Float,
        val rating: Int,
        val created: Date
)