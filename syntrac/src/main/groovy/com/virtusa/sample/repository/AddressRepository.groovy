package com.virtusa.sample.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository

import com.virtusa.sample.domain.Address

@RestResource
@Repository
interface AddressRepository extends JpaRepository<Address, Long>{

}
