package org.kktec.gpool

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class PoolController {

	def home() {
		render view: 'home', model: [title: 'Home']
	}
}
