
package org.kktec.security

import org.kktec.security.User;

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
		value                 || error
		' '                   || 'blank'
		'ab'                  || 'minSize'
		'abc'                 || null
		'a'.padRight(21, '_') || 'maxSize'
		'a'.padRight(20, '_') || null
		'ken'                 || 'unique'
	}

	@Unroll
	def 'passwordHash with value #value validation error is #error'() {
		given:
		user.passwordHash = value
		user.validate()
		
		expect:
		user.errors.passwordHash == error
		
		where:
		value                 || error
		' '                   || 'blank'
		'a'.padRight(61, '_') || 'maxSize'
		'a'.padRight(60, '_') || null
	}

	def 'can convert User toString'() {
		expect:
		user.toString() == 'ken'
	}
}
