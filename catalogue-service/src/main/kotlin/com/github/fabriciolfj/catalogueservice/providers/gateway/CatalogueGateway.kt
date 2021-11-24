package com.github.fabriciolfj.catalogueservice.providers.gateway

import com.github.fabriciolfj.catalogueservice.domain.Catalogue
import com.github.fabriciolfj.catalogueservice.providers.database.entities.CatalogueEntity
import com.github.fabriciolfj.catalogueservice.providers.database.entities.toDomain
import com.github.fabriciolfj.catalogueservice.providers.database.entities.toEntity
import com.github.fabriciolfj.catalogueservice.providers.database.repository.CatalogueRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class CatalogueGateway {

    @Autowired
    private lateinit var repository: CatalogueRepository

    fun save(catalogue: Catalogue) {
        repository.save(CatalogueEntity().toEntity(catalogue))
    }

    fun findById(id: Long) : Catalogue {
        return repository.findById(id)
            .map { it.toDomain() }
            .orElseThrow { throw RuntimeException("Catalogue not found $id") }
    }
}