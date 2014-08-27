package org.kktec.gpool.user

import grails.plugin.springsecurity.annotation.Secured

import org.kktec.security.PasswordCommand
import org.kktec.security.User


@Secured(['ROLE_USER'])
class UserController {
	
	def springSecurityService
	
	def userService
	
	def profile() {
		render view: 'profile', model: [title: 'Profile']
	}
	
	def changePassword(PasswordCommand command) {
		Map model = [title: 'Change Password', command: command]
		render view: 'changePassword',  model: model
	}
	
	def updatePassword(PasswordCommand command) {
		if (!command.hasErrors()) {
			User user = springSecurityService.currentUser
			user.passwordHash = springSecurityService.encodePassword(command.newPassword)
			if (userService.saveUser(user)) {
				springSecurityService.reauthenticate(user.username)
				flash.message = 'Your password has been updated'
				redirect action: 'profile'
				return
			}
			
			flash.message = 'Your password has NOT been updated'
		}
		
		changePassword(command)
	}

	def changeEmail() {
		render view: 'changeEmail',  model: [title: 'Change Email']
	}

}

