package com.github.fabriciolfj.catalogueservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CatalogueServiceApplication

fun main(args: Array<String>) {
	runApplication<CatalogueServiceApplication>(*args)
}
