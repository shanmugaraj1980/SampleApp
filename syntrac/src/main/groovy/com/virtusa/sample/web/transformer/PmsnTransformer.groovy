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
 * @author Shan.
 *
 */
@Component
class PmsnTransformer {
	static DateTimeFormatter formatter = DateTimeFormat.forPattern("MM/dd/yyyy")

	def transform(pmsn) {
		pmsns.collect{ transformOne(it) }
	}

	def transformOne(pmsn) {
		// No-need of explicit DTO object.
		[id:pmsn.pmsnnum,pmsnName:pmsn.pmsnName,pmsnDesc:pmsn.pmsnDesc,rowAddStp:formatter.print(pmsn.rowAddStp),
			rowAddUserid:pmsn.rowAddUserid,rowUpdateStp:formatter.print(pmsn.rowUpdateStp),rowUpdateUserid:pmsn.rowUpdateUserid]
	}
}
