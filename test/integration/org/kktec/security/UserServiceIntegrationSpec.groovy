package org.kktec.security

import grails.test.spock.IntegrationSpec
import spock.lang.Shared

class UserServiceIntegrationSpec extends IntegrationSpec {
	
	@Shared UserService userService

	def 'can find the Users'() {
		when:
		List users = userService.users()
		
		then:
		users.size == 3
	}
	
	def 'can save an existing User'() {
		given:
		User user = User.get 1
		
		expect:
		user.version == 0
		
		when:
		user.email = 'A' + user.email
		userService.saveUser user
		
		then:
		user.version == 1
	}
	
	def 'can save a valid new User with ROLE_USER'() {
		given:
		User user = new User(
			username: 'newby',
			email: 'newby@kktec.org',
			passwordHash: 'aHash'
		)
		
		when:
		userService.saveUser user
		Set authorities = user.authorities*.authority
		
		then:
		user.id
		authorities.size() == 1
		authorities.contains 'ROLE_USER'
	}
	
	def 'can NOT save an invalid User'() {
		expect:
		!userService.saveUser(new User())
	}
}
