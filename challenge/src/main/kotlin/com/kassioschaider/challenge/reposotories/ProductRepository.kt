package com.kassioschaider.challenge.reposotories

import com.kassioschaider.challenge.documents.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, Int> {

    fun findByproductId(productId: Int): Product?
}