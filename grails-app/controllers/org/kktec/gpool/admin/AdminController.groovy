package org.kktec.gpool.admin

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class AdminController {

	def userService
	
	def index() {
		List users = userService.users()
		render view: 'admin', model: [title: 'Admin', users: users]
	}
}
