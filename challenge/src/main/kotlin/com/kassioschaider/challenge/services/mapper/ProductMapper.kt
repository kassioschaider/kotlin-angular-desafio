package com.kassioschaider.challenge.services.mapper

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.services.dtos.ProductDTO

class ProductMapper {

    constructor()

    fun convertToDto(product: Product?): ProductDTO? {
        if (product == null) {
            return null
        }
        val productDTO = ProductDTO(
                product.productId,
                product.title,
                product.type,
                product.description,
                product.filename,
                product.height,
                product.width,
                product.price,
                product.rating,
                product.created
        )

        return productDTO
    }

    fun convertToModel(productDTO: ProductDTO?): Product? {
        if (productDTO == null) {
            return null
        }
        val product = Product(
                productDTO.productId,
                productDTO.title,
                productDTO.type,
                productDTO.description,
                productDTO.filename,
                productDTO.height,
                productDTO.width,
                productDTO.price,
                productDTO.rating,
                productDTO.created
        )

        return product
    }
}