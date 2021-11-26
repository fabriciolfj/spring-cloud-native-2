package com.github.fabriciolfj.catalogueservice.controller.dto

import com.github.fabriciolfj.catalogueservice.domain.Catalogue
import java.io.Serializable
import java.math.BigDecimal

data class CatalogueResponse(val name: String, val price: BigDecimal) : Serializable {

    private val serialVersionUID = 1L

    constructor() : this("", BigDecimal.ZERO)
}

fun CatalogueResponse.toResponse(domain: Catalogue) : CatalogueResponse {
    return CatalogueResponse(domain.name, domain.price)
}