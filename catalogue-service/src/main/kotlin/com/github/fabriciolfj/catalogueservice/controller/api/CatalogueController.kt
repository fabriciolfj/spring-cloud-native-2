package com.github.fabriciolfj.catalogueservice.controller.api

import com.github.fabriciolfj.catalogueservice.controller.dto.CatalogueRequest
import com.github.fabriciolfj.catalogueservice.controller.dto.CatalogueResponse
import com.github.fabriciolfj.catalogueservice.controller.dto.toDomain
import com.github.fabriciolfj.catalogueservice.controller.dto.toResponse
import com.github.fabriciolfj.catalogueservice.usecase.DeleteUseCase
import com.github.fabriciolfj.catalogueservice.usecase.FindUseCase
import com.github.fabriciolfj.catalogueservice.usecase.SaveUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/catalogue")
class CatalogueController {

    @Autowired
    private lateinit var saveUseCase: SaveUseCase
    @Autowired
    private lateinit var findUseCase: FindUseCase
    @Autowired
    private lateinit var deleteUseCase: DeleteUseCase

    @GetMapping("/{id}")
    @Cacheable(value = ["catalogues"], key = "#id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun getCatalogue(@PathVariable("id") id: Long) : CatalogueResponse {
        return findUseCase.execute(id)
            .let { CatalogueResponse().toResponse(it) }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CatalogueRequest) : CatalogueResponse {
        return CatalogueResponse().toResponse(saveUseCase.execute(request.toDomain()))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CacheEvict(value = ["catalogues"], key = "#id")
    fun deleteCatalogue(@PathVariable("id") id: Long) {

    }
}