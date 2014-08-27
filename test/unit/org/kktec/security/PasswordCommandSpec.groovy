package org.kktec.security

import grails.test.mixin.web.ControllerUnitTestMixin
import spock.lang.Specification
import spock.lang.Unroll

@TestMixin(ControllerUnitTestMixin)
class PasswordCommandSpec extends Specification {

	PasswordCommand command = mockCommandObject(PasswordCommand)
	
	def 'a valid PasswordCommand has no errors'() {
		given:
		command.newPassword = '123456'
		command.repeatPassword = '123456'
		
		when:
		command.validate()
		
		then:
		!command.hasErrors()
	}
	
	def 'a PasswordCommand is invalid if newPassword and repeatPassword are not identical'() {
		given:
		command.newPassword = '123456'
		command.repeatPassword = 'abcdef'
		
		when:
		command.validate()
		
		then:
		command.errors.getFieldError('repeatPassword')?.code == 'nonIdentical'
	}
	
	@Unroll
	def 'newPassword with value #value validation error is #error'(String value, String error) {
		given:
		command.newPassword = value
		command.validate()
		
		expect:
		command.errors.getFieldError('newPassword')?.code == error
		
		where:
		value    || error
		''       || 'blank' 
		'123456' || null
		'12345'  || 'minSize.notmet'
	}
	
}
