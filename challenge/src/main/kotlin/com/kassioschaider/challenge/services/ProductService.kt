package com.kassioschaider.challenge.services

import com.kassioschaider.challenge.documents.Product

interface ProductService {

    fun getByProductId(productId: String): Product?

    fun addProduct(product: Product): Product

    fun findAll(): List<Product>

    fun updateProduct(product: Product): Product

    fun deleteByProductId(productId: String)
}