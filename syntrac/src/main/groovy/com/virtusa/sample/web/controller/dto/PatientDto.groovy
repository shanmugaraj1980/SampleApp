package com.virtusa.sample.web.controller.dto

import javax.validation.constraints.NotNull

import org.joda.time.DateTime

class PatientDto {

	@NotNull
	def firstName
	@NotNull
	def lastName
	def dob
	def weight 
	def mrn 
	def gender 
	def phone1 
	def phone2 
	def line1 
	def line2 
	def city 
	def state 
	def zip 
	def email 
	def maritalStatus
}
