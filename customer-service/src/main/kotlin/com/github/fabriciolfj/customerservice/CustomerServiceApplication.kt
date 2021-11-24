package com.github.fabriciolfj.customerservice

import com.github.fabriciolfj.customerservice.model.Customer
import com.github.fabriciolfj.customerservice.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CustomerServiceApplication : CommandLineRunner {

	@Autowired
	private lateinit var customerRepository: CustomerRepository

	override fun run(vararg args: String?) {
		val customers = arrayListOf(Customer(null, "Fabricio", "Fabricio@outlook.com"),
			Customer(null, "Jorge", "Jorge@outlook.com"))

		customers.forEach { customerRepository.save(it)}
	}
}

fun main(args: Array<String>) {
	runApplication<CustomerServiceApplication>(*args)
}
