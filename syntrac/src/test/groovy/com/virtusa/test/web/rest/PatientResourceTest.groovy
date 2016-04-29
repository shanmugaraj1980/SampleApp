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
class PatientResourceTest extends WebAppIntegrationBaseSpecification{
	@Unroll
	def "Create a new patient with First Name = #firstName and Last Name = #lastName and expect status = #statusCode" (firstName, lastName, dob, weight, mrn, gender, phone1, phone2, line1, line2, city, state, zip, email, maritalStatus, statusCode) {
		given:"I am an authenticated NMT"
		// TODO - Login flow
		def inputJson =  JsonOutput.toJson([firstName: firstName, lastName: lastName, dob: dob, weight: weight, mrn:mrn, gender: gender,
			phone1: phone1, phone2: phone2, line1: line1, line2:line2, city:city, state: state, zip: zip, email: email, maritalStatus: maritalStatus])
		when: "I enter all the required information for a patient"
		def createResponse = this.mockMvc.perform(post("/api/patient").content(inputJson).contentType(MediaType.APPLICATION_JSON))
		then: "a patient should be created"
		createResponse.andExpect(status().is(statusCode))
		where:
		firstName	|	lastName	|	dob				|	weight	|	mrn		|	gender	|	phone1			|	phone2			|	line1								|	line2	|	city			|	state	|	zip		|	email				|	maritalStatus	|	statusCode
		'First'		|	'Last'		|	'04/22/2016'	|	90.6	|	1232434	|	'M'		|	'1234567890'	|	'0987654321'	|	'1600, Amphitheatre Parkway Avenue'	|	null	|	'Mountain View'	| 	'CA'	|  34800	|	'test@test.com'		|	'Married'		|	201
		null		|	'Last'		|	'04/22/2016'	|	90.6	|	1232434	|	'M'		|	'1234567890'	|	'0987654321'	|	'1600, Amphitheatre Parkway Avenue'	|	null	|	'Mountain View'	| 	'CA'	|  34800	|	'test@test.com'		|	'Married'		|	400
		'First'		|	null		|	'04/22/2016'	|	90.6	|	1232434	|	'M'		|	'1234567890'	|	'0987654321'	|	'1600, Amphitheatre Parkway Avenue'	|	null	|	'Mountain View'	| 	'CA'	|  34800	|	'test@test.com'		|	'Married'		|	400
	}
	
	
	static createPatient(mockMvc,firstName,lastName) {
		def inputJson =  JsonOutput.toJson([firstName: firstName, lastName: lastName, dob: '02/04/2006', weight: 80.6, mrn:null, gender: 'M',
			phone1: null, phone2: null, line1: '1 New York Plaza', line2:null, city:'New York', 
			state: 'NY', zip: '10004', email: 'garrus@sniper.com', maritalStatus: null])

		mockMvc.perform(post("/api/patient").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(201))
	}
}
