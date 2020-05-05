package com.kassioschaider.challenge.services.dtos

import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ProductDTO(
        var productId: String? = null,

        @NotEmpty(message = "Title can not be empty.")
        var title: String,

        @NotEmpty(message = "Type can not be empty.")
        var type: String,
        var description: String,
        var filename: String,
        var height: Int,
        var width: Int,

        @NotNull(message = "Price can not be empty.")
        var price: Float,
        var rating: Int,
        var created: LocalDateTime?
)