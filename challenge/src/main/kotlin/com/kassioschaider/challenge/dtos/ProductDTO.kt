package com.kassioschaider.challenge.dtos

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ProductDTO (
        val productId: String? = null,

        @NotEmpty(message = "Title can not be empty.")
        val title: String,

        @NotEmpty(message = "Type can not be empty.")
        val type: String,
        val description: String,
        val filename: String,
        val height: Int,
        val width: Int,

        @NotNull(message = "Price can not be empty.")
        val price: Float,
        val rating: Int
)