package com.kassioschaider.challenge.controllers

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.services.dtos.ProductDTO
import com.kassioschaider.challenge.services.ProductService
import org.omg.CORBA.Object
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.stream.Stream
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ProductController(val productService: ProductService) {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @GetMapping("/products")
    fun list(): Stream<ProductDTO?> {
        return productService.findAll()
    }

//    @PostMapping("products")
//    fun add(@RequestBody productsDTO: List<ProductDTO>,
//            result: BindingResult): ResponseEntity<Response<List<ProductDTO>>> {
//        val response: Response<List<ProductDTO>> = Response<List<ProductDTO>>()
//        validateFile(productsDTO, result)
//
//        if (result.hasErrors()) {
//            for (error in result.allErrors) response.errors.add(error.defaultMessage.toString())
//            return ResponseEntity.badRequest().body(response)
//        }
//
//        return ResponseEntity.ok(response)
//    }

    @PostMapping("/products")
    fun add(@RequestBody products: List<ProductDTO>) {
        for (product in products) {
            productService.addProduct(product)
        }
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
    fun get(@RequestBody @Valid product: Product, @PathVariable productId: String): Product {
        return productService.updateProduct(product)
    }

    private fun validateFile(productsDTO: List<Product>, result: BindingResult) {
        TODO("Not yet implemented")
    }
}