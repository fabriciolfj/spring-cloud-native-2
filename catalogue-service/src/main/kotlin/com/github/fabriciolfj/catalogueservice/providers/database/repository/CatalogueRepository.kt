package com.github.fabriciolfj.catalogueservice.providers.database.repository

import com.github.fabriciolfj.catalogueservice.providers.database.entities.CatalogueEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CatalogueRepository : JpaRepository<CatalogueEntity, Long>