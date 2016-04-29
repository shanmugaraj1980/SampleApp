package com.virtusa.sample.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.virtusa.sample.domain.Address
import com.virtusa.sample.repository.AddressRepository

@Service
class AddressService {

	@Autowired
	AddressRepository addressRepository

	@Transactional
	def save(dto) {
		addressRepository.save new Address(line1: dto.line1, line2:dto.line2, phone1: dto.phone1, phone2: dto.phone2, city: dto.city,
		zip: dto.zip, state: dto.state)
	}
}
