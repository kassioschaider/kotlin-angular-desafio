package com.kassioschaider.challenge

import com.kassioschaider.challenge.documents.Product
import com.kassioschaider.challenge.reposotories.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class ChallengeApplication(val productRepository: ProductRepository) : CommandLineRunner {
	override fun run(vararg args: String?) {
//		productRepository.deleteAll()
		val product: Product = Product(title = "Teste",	created = Date(999999),
				description = "descrição", filename = "test.jpg", height = 100,
				width = 200, price = 12.0f, rating = 10, type = "exemplo")
		productRepository.save(product)

		println(productRepository.findAll().toString())
	}

}

fun main(args: Array<String>) {
	runApplication<ChallengeApplication>(*args)
}
