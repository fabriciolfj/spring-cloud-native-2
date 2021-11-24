package com.github.fabriciolfj.catalogueservice.usecase

import com.github.fabriciolfj.catalogueservice.domain.Catalogue
import com.github.fabriciolfj.catalogueservice.providers.gateway.CatalogueGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FindUseCase {

    @Autowired
    private lateinit var gateway: CatalogueGateway

    fun execute(id: Long) : Catalogue {
        return gateway.findById(id)
    }
}