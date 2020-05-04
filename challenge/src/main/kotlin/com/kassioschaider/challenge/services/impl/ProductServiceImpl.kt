package com.kassioschaider.challenge.services.impl

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.reposotories.ProductRepository
import com.kassioschaider.challenge.services.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {

    override fun getByProductId(productId: Int): Product? = productRepository.findByproductId(productId)

    override fun addProduct(product: Product): Product = productRepository.save(product)

    override fun findAll(): List<Product> = productRepository.findAll()
}