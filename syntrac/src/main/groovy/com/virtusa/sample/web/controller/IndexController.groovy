/**
 * 
 */
package com.virtusa.sample.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Index.
 *
 * @author Karthik.
 *
 */
@Controller
@RequestMapping("/index")
class IndexController {

	@RequestMapping("")
	def index() {
		'index'
	}
}
