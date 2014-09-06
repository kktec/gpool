package org.kktec.security

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(User)
class UserSpec extends Specification implements TestUserFactory {
	
	User user = validUser('ken')
	
	def setup() {
		mockForConstraintsTests User
	}
	
	def 'a valid User has no errors'() {
		when:
		user.validate()
		
		then:
		!user.hasErrors()
	}
	
	@Unroll
	def 'username with value #value validation error is #error'() {
		given:
		mockForConstraintsTests(User, [validUser('ken'), user])
		user.username = value
		user.validate()
		
		expect:
		user.errors.username == error
		
		where:
		value                  || error
		' '                    || 'blank'
		'ab'                   || 'minSize'
		'abc'                  || null
		'21'.padRight(21, 'a') || 'maxSize'
		'20'.padRight(20, 'a') || null
		'ken'                  || 'unique'
	}

	@Unroll
	def 'passwordHash with value #value validation error is #error'() {
		given:
		user.passwordHash = value
		user.validate()
		
		expect:
		user.errors.passwordHash == error
		
		where:
		value                  || error
		' '                    || 'blank'
		'61'.padRight(61, 'a') || 'maxSize'
		'60'.padRight(60, 'a') || null
	}

	@Unroll
	def 'email with value #value validation error is #error'() {
		given:
		mockForConstraintsTests(User, [validUser('ken'), user])
		user.email = value
		user.validate()
		
		expect:
		user.errors.email == error
		
		where:
		value                            || error
		' '                              || 'blank'
		'abcdefg'                        || 'email'
		'46'.padRight(46, 'a') + '@a.co' || 'maxSize'
		'45'.padRight(45, 'a') + '@a.co' || null
		'ken@kktec.org'                  || null
	}

	def 'can convert User toString'() {
		expect:
		user.toString() == 'ken'
	}
}
