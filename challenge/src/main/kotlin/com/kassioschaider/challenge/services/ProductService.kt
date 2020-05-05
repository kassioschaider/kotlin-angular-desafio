package com.kassioschaider.challenge.services

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.services.dtos.ProductDTO
import com.kassioschaider.challenge.services.dtos.ProductListDTO
import java.util.stream.Stream

interface ProductService {

    fun getByProductId(productId: String): Product?

    fun addProduct(productDto: ProductDTO): Product?

    fun findAll(): Stream<ProductDTO?>

    fun updateProduct(product: Product): Product

    fun deleteByProductId(productId: String)
}