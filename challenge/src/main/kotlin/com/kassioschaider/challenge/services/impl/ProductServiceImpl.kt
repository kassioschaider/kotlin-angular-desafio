package com.kassioschaider.challenge.services.impl

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.reposotories.ProductRepository
import com.kassioschaider.challenge.services.ProductService
import com.kassioschaider.challenge.services.dtos.ProductDTO
import com.kassioschaider.challenge.services.mapper.ProductMapper
import org.springframework.stereotype.Service
import java.util.stream.Stream

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {

    private val productMapper = ProductMapper()

    override fun getByProductId(productId: String): Product? = productRepository.findByProductId(productId)

    override fun addProduct(product: Product) : Product {
        return productRepository.save(product)
    }

    override fun findAll(): Stream<ProductDTO?> {
        return productRepository.findAll().stream().map { productMapper.convertToDto(it) }
    }

    override fun updateProduct(product: Product): Product = productRepository.save(product)

    override fun deleteByProductId(productId: String) { productRepository.deleteByProductId(productId) }

}