package com.github.fabriciolfj.catalogueservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class CatalogueServiceApplication

fun main(args: Array<String>) {
	runApplication<CatalogueServiceApplication>(*args)
}
