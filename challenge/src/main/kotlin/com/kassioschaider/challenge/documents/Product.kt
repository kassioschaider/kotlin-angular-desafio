package com.kassioschaider.challenge.documents

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Product (
        @Id val productId: String? = null,
        val title: String,
        val type: String,
        val description: String,
        val filename: String,
        val height: Int,
        val width: Int,
        val price: Float,
        val rating: Int,
        val created: Date
)
