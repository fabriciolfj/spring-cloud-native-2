package com.github.fabriciolfj.customerservice.controller

import com.github.fabriciolfj.customerservice.model.Customer
import com.github.fabriciolfj.customerservice.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class CustomerController {

    @Autowired
    private lateinit var repository: CustomerRepository

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_TESTE')")
    fun findAll() : List<Customer> {
        return repository.findAll()
    }
}