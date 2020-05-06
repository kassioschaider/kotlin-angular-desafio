package com.kassioschaider.challenge.controllers

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.services.dtos.ProductDTO
import com.kassioschaider.challenge.services.ProductService
import org.omg.CORBA.Object
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.stream.Stream

@RestController
@RequestMapping("/api")
class ProductController(val productService: ProductService) {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @GetMapping("/products")
    fun list(): Stream<ProductDTO?> {
        return productService.findAll()
    }

    @PostMapping("/products")
    fun add(@RequestBody products: List<ProductDTO>): ResponseEntity<Object> {
        println(products.toString())
        for (product in products) {
            productService.addProduct(product)
        }
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/products/{productId}")
    fun delete(@PathVariable productId: String) {
        productService.deleteByProductId(productId)
    }

    @GetMapping("/products/{productId}")
    fun get(@PathVariable productId: String): Product? {
        return productService.getByProductId(productId)
    }

    @PutMapping("/products/{productId}")
    fun get(@RequestBody product: ProductDTO, @PathVariable productId: String): Product {
        return productService.updateProduct(product)
    }

    private fun validateFile(productsDTO: List<Product>, result: BindingResult) {
        TODO("Not yet implemented")
    }
}