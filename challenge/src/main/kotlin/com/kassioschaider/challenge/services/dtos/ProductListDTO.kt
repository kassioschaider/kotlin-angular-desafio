package com.kassioschaider.challenge.services.dtos

import java.time.LocalDate

data class ProductListDTO(
        val productId: String? = null,
        val title: String,
        val type: String,
        val price: Float,
        val rating: Int,
        val created: LocalDate?
)