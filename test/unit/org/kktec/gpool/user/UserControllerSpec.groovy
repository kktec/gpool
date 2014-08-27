package org.kktec.gpool.user

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.TestFor

import org.kktec.security.PasswordCommand
import org.kktec.security.TestUserFactory
import org.kktec.security.User
import org.kktec.security.UserService

import spock.lang.Specification

@TestFor(UserController)
class UserControllerSpec extends Specification implements TestUserFactory {
	
	SpringSecurityService springSecurityService = Mock()
	
	UserService userService = Mock()
	
	User user = validUser('user')
	
	PasswordCommand command = new PasswordCommand(
		newPassword: '123456',
		repeatPassword: '123456'
	)
		
	def setup() {
		controller.springSecurityService = springSecurityService
		controller.userService = userService
	}
	
	def 'a user can view their profile'() {
		when:
		controller.profile()
		
		then:
		1 * springSecurityService.currentUser >> user
		0 * _
		view == '/user/profile'
		model.title == 'Profile'
		model.email == 'user@kktec.org'
	}
	
	def 'a user can change their password'() {
		when:
		controller.changePassword()
		
		then:
		0 * _
		view == '/user/changePassword'
		model.title == 'Change Password'
	}

	def 'a user can change their profile'() {
		when:
		controller.changeProfile()
		
		then:
		1 * springSecurityService.currentUser >> user
		0 * _
		view == '/user/changeProfile'
		model.title == 'Change Profile'
		model.user == user
	}
	
	def 'a user can update their password'() {
		when:
		controller.updatePassword(command)
		
		then:
		1 * springSecurityService.currentUser >> user
		1 * springSecurityService.encodePassword('123456') >> '123'
		user.passwordHash == '123'
		1 * userService.saveUser(user) >> true
		1 * springSecurityService.reauthenticate(user.username)
		0 * _
		response.redirectedUrl == '/user/profile'
		flash.message == 'Your password has been updated' 
	}
	
	def 'a user can NOT update a bad password'() {
		when:
		controller.updatePassword(command)
		
		then:
		1 * springSecurityService.currentUser >> user
		1 * springSecurityService.encodePassword('123456') >> '123'
		user.passwordHash == '123'
		1 * userService.saveUser(user) >> false
		0 * _
		view == '/user/changePassword'
		model.title == 'Change Password'
		model.command == command
		flash.message == 'Your password has NOT been updated'
	}
	
	def 'a user can update their profile'() {
		when:
		controller.updateProfile('xyz@x.com')
		
		then:
		1 * springSecurityService.currentUser >> user
		user.email == 'xyz@x.com'
		1 * userService.saveUser(user) >> true
		0 * _
		response.redirectedUrl == '/user/profile'
		flash.message == 'Your profile has been updated'
	}
	
	def 'a user can NOT update an invalid profile'() {
		when:
		controller.updateProfile('')
		
		then:
		1 * springSecurityService.currentUser >> user
		user.email == ''
		1 * userService.saveUser(user) >> false
		0 * _
		view == '/user/changeProfile'
		model.title == 'Change Profile'
		model.user == user
	}
	
}
