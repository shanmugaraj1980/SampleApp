package com.virtusa.sample.web.resource

import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import com.virtusa.sample.service.PmsnService
import com.virtusa.sample.web.controller.dto.PatientDto;
import com.virtusa.sample.web.controller.dto.PmsnDto
import com.virtusa.sample.web.transformer.PmsnTransformer

@RestController
@RequestMapping("/api/pmsn")
class PmsnResource {

	@Autowired
	PmsnService pmsnService
	
	@Autowired
	PmsnTransformer pmsnTransformer

	
	
	@RequestMapping(method=RequestMethod.GET)
	def all() {
		pmsnTransformer.transform(pmsnService.all())
	}
	
	@RequestMapping(method=RequestMethod.POST)
	def create(@Valid @RequestBody PmsnDto pmsnDto) {
		ResponseEntity.created(new URI("/api/pmsn/${pmsnService.save(pmsnDto).id}")).build()
	}
}
