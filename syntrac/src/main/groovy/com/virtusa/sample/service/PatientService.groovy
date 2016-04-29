package com.virtusa.sample.service

import org.codehaus.groovy.runtime.InvokerHelper
import org.joda.time.format.DateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.virtusa.sample.domain.Patient
import com.virtusa.sample.repository.PatientRepository

@Service
class PatientService {

	@Autowired
	AddressService addressService

	@Autowired
	PatientRepository patientRepository

	@Transactional
	def save(dto){
		patientRepository.save(
				new Patient(firstName:dto.firstName, lastName: dto.lastName, email: dto.email, gender: dto.gender,
				dob: DateTimeFormat.forPattern("MM/dd/yyyy").parseDateTime(dto.dob), address : addressService.save(dto)
				))
	}
	
	@Transactional
	def update(id,dto) {
		def patient = patientRepository.findOne(id)
		
		copyProperties(patient,dto)
		copyProperties(patient.address,dto)
		patient.dob = DateTimeFormat.forPattern("MM/dd/yyyy").parseDateTime(dto.dob)
	}
	
	void copyProperties(dest,src) {
		src.properties.each{prop, val ->
			if(prop in ["metaClass","class"]) return
			if(prop!='dob' && dest.hasProperty(prop)) dest[prop] = val
		}
	}
	
	
	def all() {
		patientRepository.findAllWithAddress()
	}
	
	def get(id) {
		patientRepository.findOneWithAddress(id)
	}
	
	@Transactional
	def delete(id) {
		patientRepository.delete(id)
	}
}
