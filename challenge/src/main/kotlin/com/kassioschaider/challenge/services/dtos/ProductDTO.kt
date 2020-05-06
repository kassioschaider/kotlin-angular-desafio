package com.kassioschaider.challenge.services.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.validator.constraints.Length
import org.springframework.web.bind.annotation.PutMapping
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class ProductDTO(
        var productId: String? = null,

        @get:NotEmpty(message = "Title can not be empty.")
        @get:Length(min = 3, max = 50, message = "Must be between 3 and 50 letters!")
        var title: String,

        @get:NotEmpty(message = "Type can not be empty.")
        @get:Length(min = 3, max = 50, message = "Must be between 3 and 50 letters")
        var type: String,
        var description: String,
        var filename: String,
        var height: Int,
        var width: Int,

        @get:NotNull(message = "Price can not be empty.")
        @get:Min(0, message = "Price can not be below 0.")
        var price: Float,
        var rating: Int,
        var created: LocalDate?
)