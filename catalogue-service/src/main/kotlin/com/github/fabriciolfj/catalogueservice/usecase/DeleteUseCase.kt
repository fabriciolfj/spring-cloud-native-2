package com.github.fabriciolfj.catalogueservice.usecase

import com.github.fabriciolfj.catalogueservice.providers.gateway.CatalogueGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeleteUseCase {

    @Autowired
    private lateinit var catalogueGateway: CatalogueGateway

    fun delete(id: Long) {
        catalogueGateway.delete(id)
    }
}