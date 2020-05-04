package com.kassioschaider.challenge.services.impl

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.reposotories.ProductRepository
import com.kassioschaider.challenge.services.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {

    override fun getByProductId(productId: String): Product? = productRepository.findByProductId(productId)

    override fun addProduct(product: Product): Product = productRepository.save(product)

    override fun findAll(): List<Product> = productRepository.findAll()

    override fun updateProduct(product: Product): Product = productRepository.save(product)

    override fun deleteByProductId(productId: String) { productRepository.deleteByProductId(productId) }

}