package org.kktec.gpool.admin

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.TestFor

import org.kktec.security.Role
import org.kktec.security.User
import org.kktec.security.UserService

import spock.lang.Specification

@TestFor(AdminController)
class AdminControllerSpec extends Specification {

	SpringSecurityService springSecurityService = Mock()
	
	UserService userService = Mock()
	
	def setup() {
		controller.springSecurityService = springSecurityService
		controller.userService = userService
	}
	
	def 'an admin can view the Admin page with a list of Users'() {
		given:
		List users = ['a', 'b', 'c']
		
		when:
		controller.index()
		
		then:
		1 * userService.users() >> users
		0 * _
		view == '/admin/admin'
		model.title == 'Admin'
		model.users == users
	}
	
	def 'an admin can view a form to add a new User'() {
		when:
		controller.addUser()
		
		then:
		0 * _
		view == '/admin/addUser'
		model.title == 'Add User'
		model.user
	}
	
	def 'an admin can create a valid new User'() {
		given:
		params.username = 'newby'
		params.email = 'newby@kktec.org'
		
		when:
		controller.createUser()
		
		then:
		1 * springSecurityService.encodePassword('newuser') >> 'newuser_hash'
		1 * userService.saveUser(_) >> { User user ->
			with(user) {
				username == params.username
				email == params.email
				enabled
				passwordHash == 'newuser_hash'
			}
			true
		}
		0 * _
		flash.message == 'Added a new User: newby'
		response.redirectedUrl == '/admin/index'
	}
	
	def 'an admin can NOT create a new invalid User'() {
		when:
		controller.createUser()
		
		then:
		1 * springSecurityService.encodePassword('newuser') >> 'newuser_hash'
		1 * userService.saveUser(_) >> false
		0 * _
		view == '/admin/addUser'
		model.user
	}
}
