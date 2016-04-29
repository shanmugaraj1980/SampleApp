/**
 * 
 */
package com.virtusa.sample.web.transformer

import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.stereotype.Component

/**
 * Transformer.
 *
 * @author Karthik.
 *
 */
@Component
class PatientTransformer {
	static DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy")

	def transform(patients) {
		patients.collect{ transformOne(it) }
	}

	def transformOne(patient) {
		// No-need of explicit DTO object.
		[id:patient.id,firstName:patient.firstName,lastName:patient.lastName,gender:patient.gender,
			email:patient.email,line1:patient.address.line1,line2:patient.address.line2,city:patient.address.city,
			state:patient.address.state,zip:patient.address.zip,dob:formatter.print(patient.dob)]
	}
}
