package com.github.fabriciolfj.catalogueservice.providers.database.entities

import com.github.fabriciolfj.catalogueservice.domain.Catalogue
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "catalogue")
data class CatalogueEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(nullable = false)
    var name: String,
    @Column(nullable = false)
    val price: BigDecimal
) {
    constructor() : this(null, "", BigDecimal.ZERO)
}

fun CatalogueEntity.toEntity(domain: Catalogue) : CatalogueEntity {
    return CatalogueEntity(null, domain.name, domain.price)
}

fun CatalogueEntity.toDomain() : Catalogue {
    return Catalogue(this.name, this.price)
}