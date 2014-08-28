package org.kktec.gpool.admin

import grails.test.mixin.TestFor

import org.kktec.security.UserService

import spock.lang.Specification

@TestFor(AdminController)
class AdminControllerSpec extends Specification {

	UserService userService = Mock()
	
	def setup() {
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
}

