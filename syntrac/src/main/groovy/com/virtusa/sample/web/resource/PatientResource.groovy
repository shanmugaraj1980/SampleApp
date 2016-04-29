package com.virtusa.sample.web.resource

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.virtusa.sample.service.PatientService
import com.virtusa.sample.web.controller.dto.PatientDto
import com.virtusa.sample.web.transformer.PatientTransformer

@RestController
@RequestMapping("/api/patient")
class PatientResource {

	@Autowired
	PatientService patientService
	
	@Autowired
	PatientTransformer patientTransformer

	@RequestMapping(method=RequestMethod.POST)
	def create(@Valid @RequestBody PatientDto patientDto) {
		ResponseEntity.created(new URI("/api/patient/${patientService.save(patientDto).id}")).build()
	}
	
	@RequestMapping(method=RequestMethod.GET)
	def all() {
		patientTransformer.transform(patientService.all())
	}
	
	@RequestMapping(value='/{id}',method=RequestMethod.GET)
	def get(@PathVariable("id") Long id) {
		patientTransformer.transformOne(patientService.get(id))
	}
	
	@RequestMapping(value='/{id}',method=RequestMethod.PUT)
	def update(@PathVariable("id") Long id,@Valid @RequestBody PatientDto patientDto) {
		patientService.update(id,patientDto)
		ResponseEntity.ok().build()
	}
	
	@RequestMapping(value='/{id}',method=RequestMethod.DELETE)
	def delete(@PathVariable("id") Long id) {
		patientService.delete(id)
		ResponseEntity.noContent().build()
	}
}
