package com.virtusa.sample.service

import org.codehaus.groovy.runtime.InvokerHelper
import org.joda.time.format.DateTimeFormat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import com.virtusa.sample.domain.Pmsn
import com.virtusa.sample.repository.PmsnRepository

@Service
class PmsnService {


	@Autowired
	PmsnRepository pmsnRepository

		
	
	def all() {
		pmsnRepository.findAll()
	}
	
	@Transactional
	def save(dto){
		pmsnRepository.save(
				new Pmsn(pmsnName:dto.pmsnName, pmsnDesc: dto.pmsnDesc, rowAddStp: DateTimeFormat.forPattern("MM/dd/yyyy").parseDateTime(dto.rowAddStp),rowAddUserid: dto.rowAddUserid,  rowUpdateStp: DateTimeFormat.forPattern("MM/dd/yyyy").parseDateTime(dto.rowUpdateStp),rowUpdateUserid: dto.rowUpdateUserid
				))
	}
	
}
