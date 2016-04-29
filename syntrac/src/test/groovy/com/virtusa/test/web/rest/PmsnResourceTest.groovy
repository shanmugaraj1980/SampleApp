package com.virtusa.test.web.rest

import static org.hamcrest.collection.IsCollectionWithSize.hasSize
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

import org.springframework.http.MediaType

import spock.lang.Unroll

import com.virtusa.test.base.TransactionalWebIntegrationTest
import com.virtusa.test.base.WebAppIntegrationBaseSpecification

@TransactionalWebIntegrationTest
class PmsnResourceTest extends WebAppIntegrationBaseSpecification{
	@Unroll
	def "Create a new pmsn with pmsn name = #pmsnName and pmsn desc = #pmsnDesc and row add stp = #rowAddStp and row add user id = #rowAddUserId" (pmsnName, pmsnDesc, rowAddStp, rowAddUserId) {
		given:"I am an authenticated NMT"
		// TODO - Login flow
		def inputJson =  JsonOutput.toJson([pmsnName: pmsnName, pmsnDesc: pmsnDesc, rowAddStp: rowAddStp, rowAddUserId: rowAddUserId])
		when: "I enter all the required information for a permission"
		def createResponse = this.mockMvc.perform(post("/api/pmsn").content(inputJson).contentType(MediaType.APPLICATION_JSON))
		then: "a permission should be created"
		createResponse.andReturn()
		//createResponse.andExpect(status().is(statusCode))
		where:
		pmsnName		|	pmsnDesc		|	rowAddStp		|	rowAddUserId
		'First 1'		|	'Desc 1'		|	'04/27/2016'	|	'user1'			
		'First 2'		|	'Desc 2'		|	'04/28/2016'	|	'user1'
		'First 3'		|	'Desc 3'		|	'04/27/2016'	|	'user1'
	}
	
	
	static createPmsn(mockMvc,pmsnName,pmsnDesc, rowAddStp, rowAddUserId) {
		def inputJson =  JsonOutput.toJson([pmsnName: pmsnName, pmsnDesc: pmsnDesc, rowAddStp: rowAddStp, weight: rowAddUserId])

		mockMvc.perform(post("/api/pmsn").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(201))
	}
}
