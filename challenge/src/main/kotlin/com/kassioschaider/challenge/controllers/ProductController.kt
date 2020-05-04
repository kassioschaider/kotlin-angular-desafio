package com.kassioschaider.challenge.controllers

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.dtos.ProductDTO
import com.kassioschaider.challenge.dtos.ProductListDTO
import com.kassioschaider.challenge.services.ProductService
import com.kassioschaider.challenge.util.Response
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import javax.validation.Valid

@RestController
@RequestMapping("/")
class ProductController(val productService: ProductService) {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    @GetMapping("products")
    fun list(): List<Product> {
        return productService.findAll()
    }

    @PostMapping("products")
    fun add(@RequestBody productsDTO: Array<ProductDTO>,
            result: BindingResult): ResponseEntity<Response<Array<ProductDTO>>> {
        val response: Response<Array<ProductDTO>> = Response<Array<ProductDTO>>()
        validateFile(productsDTO, result)

        if (result.hasErrors()) {
            for (error in result.allErrors) response.errors.add(error.defaultMessage.toString())
            return ResponseEntity.badRequest().body(response)
        }

        return ResponseEntity.ok(response)
    }

    private fun validateFile(productsDTO: Array<ProductDTO>, result: BindingResult) {
        TODO("Not yet implemented")
    }
}