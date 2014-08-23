package org.kktec.security

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll;

@TestFor(Role)
class RoleSpec extends Specification implements TestUserFactory {
	
	Role role = validRole()
	
	def setup() {
		mockForConstraintsTests Role
	}
	
	def 'a valid Role has no errors'() {
		when:
		role.validate()
		
		then:
		!role.hasErrors()
	}

	@Unroll
	def 'authority with value #value validation error is #error'() {
		given:
		mockForConstraintsTests(Role, [validRole(), role])
		role.authority = value
		role.validate()
		
		expect:
		role.errors.authority == error
		
		where:
		value                 || error
		' '                   || 'blank'
		'a'.padRight(51, '_') || 'maxSize'
		'a'.padRight(50, '_') || null
		'ROLE_USER'           || 'unique'
	}
	
	def 'can convert Role toString'() {
		expect:
		role.toString() == 'ROLE_USER'
	}
}
