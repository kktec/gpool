package org.kktec.gpool.user

import grails.plugin.springsecurity.annotation.Secured

import org.kktec.security.PasswordCommand
import org.kktec.security.User


@Secured(['ROLE_USER'])
class UserController {
	
	def springSecurityService
	
	def userService
	
	def profile() {
		User user = springSecurityService.currentUser
		render view: 'profile', model: [title: 'Profile', email: user.email]
	}
	
	def changePassword(PasswordCommand command) {
		Map model = [title: 'Change Password', command: command]
		render view: 'changePassword',  model: model
	}
	
	def updatePassword(PasswordCommand command) {
		if (!command.hasErrors()) {
			User user = springSecurityService.currentUser
			user.passwordHash = springSecurityService.encodePassword(command.newPassword)
			def saved = userService.saveUser(user)
			if (saved) {
				springSecurityService.reauthenticate(user.username)
				flash.message = 'Your password has been updated'
				redirect action: 'profile'
				return
			}
			
			flash.message = 'Your password has NOT been updated'
		}
		
		changePassword(command)
	}

	def changeProfile(User user) {
		User theUser = user ?: springSecurityService.currentUser
		render view: 'changeProfile',  model: [title: 'Change Profile', user: theUser]
	}
	
	def updateProfile(String email) {
		User user = springSecurityService.currentUser
		user.email = email
		if (userService.saveUser(user)) {
			flash.message = 'Your profile has been updated'
			redirect action: 'profile'
			return
		}
		
		changeProfile(user)
	}
}

