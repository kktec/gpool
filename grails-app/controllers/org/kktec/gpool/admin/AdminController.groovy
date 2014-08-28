package org.kktec.gpool.admin

import grails.plugin.springsecurity.annotation.Secured

import org.kktec.security.User

@Secured(['ROLE_ADMIN'])
class AdminController {

	def springSecurityService

	def userService
	
	def index() {
		List users = userService.users()
		render view: 'admin', model: [title: 'Admin', users: users]
	}
	
	def addUser(User user) {
		User theUser = user ?: new User()
		render view: 'addUser', model: [title: 'Add User', user: theUser]
	}
	
	def createUser() {
		String hash = springSecurityService.encodePassword('newuser')
		User user = new User(
			username: params.username,
			email: params.email,
			enabled: true,
			passwordHash: hash
		)
		
		if (userService.saveUser(user)) {
			flash.message = "Added a new User: $user.username"
			redirect action: 'index'
			return
		}
		
		addUser(user)
	}
}
