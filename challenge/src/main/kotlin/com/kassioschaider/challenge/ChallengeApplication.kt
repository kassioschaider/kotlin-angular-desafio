package com.kassioschaider.challenge

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.reposotories.ProductRepository
import com.kassioschaider.challenge.services.mapper.ProductMapper
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDateTime
import java.util.*

@SpringBootApplication
class ChallengeApplication(val productRepository: ProductRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
//		productRepository.deleteAll()
		val product: Product = Product(title = "Teste",
				description = "descrição", filename = "test.jpg", height = 100,
				width = 200, price = 12.0f, rating = 10, type = "exemplo")
		productRepository.save(product)

		val productMapperImpl = ProductMapper()
		println(productMapperImpl.convertToDto(product).toString())

		println(productRepository.findAll().toString())
	}

}

fun main(args: Array<String>) {
	runApplication<ChallengeApplication>(*args)
}
