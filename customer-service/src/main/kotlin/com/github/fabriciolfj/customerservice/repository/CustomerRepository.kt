package com.github.fabriciolfj.customerservice.repository

import com.github.fabriciolfj.customerservice.model.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {
}