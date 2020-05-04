package com.kassioschaider.challenge.services

import com.kassioschaider.challenge.documents.Product

interface ProductService {

    fun getByProductId(productId: Int): Product?

    fun addProduct(product: Product): Product

    fun findAll(): List<Product>
}