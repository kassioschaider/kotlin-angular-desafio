package com.kassioschaider.challenge.services.mapper

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.dtos.ProductDTO
import com.kassioschaider.challenge.dtos.ProductListDTO

class ProductMapper() {

    fun productToListDto(product: Product) = ProductListDTO(
            productId = product.productId,
            title = product.title,
            type = product.type,
            price = product.price,
            rating = product.rating,
            created = product.created
    )

    fun listProductToListDto(products: Array<Product>): MutableList<ProductListDTO> {
        var productsListDTO: MutableList<ProductListDTO>? = null
        products.forEach {
            productsListDTO?.add(productToListDto(it))
        }

        return productsListDTO!!
    }
}