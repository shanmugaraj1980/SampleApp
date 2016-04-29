package com.virtusa.sample.web.controller.dto

import javax.validation.constraints.NotNull

import org.joda.time.DateTime

class PmsnDto {

	@NotNull
	def pmsnName
	@NotNull
	def pmsnDesc
	@NotNull
	def rowAddStp
	@NotNull
	def rowAddUserid
	@NotNull
	def rowUpdateStp
	@NotNull
	def rowUpdateUserid
	
}
