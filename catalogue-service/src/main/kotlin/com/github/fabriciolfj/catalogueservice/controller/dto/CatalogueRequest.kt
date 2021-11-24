package com.github.fabriciolfj.catalogueservice.controller.dto

import com.github.fabriciolfj.catalogueservice.domain.Catalogue
import java.math.BigDecimal

data class CatalogueRequest(val name: String, val price: BigDecimal)

fun CatalogueRequest.toDomain() : Catalogue {
    return Catalogue(this.name, this.price)
}