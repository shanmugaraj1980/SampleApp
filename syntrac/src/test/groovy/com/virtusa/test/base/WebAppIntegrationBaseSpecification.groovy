/**
 *
 */
package com.virtusa.test.base

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

/**
 * Common functionalities required for all tests go here.
 *
 * @author Karthik.
 *
 */
class WebAppIntegrationBaseSpecification extends Specification {
	MockMvc mockMvc

	@Autowired
	WebApplicationContext wac

	/**
	 * Sets up the mock web application context.
	 */
	def setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build()
	}
}
