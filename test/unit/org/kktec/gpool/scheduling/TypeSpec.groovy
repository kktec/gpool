package org.kktec.gpool.scheduling

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Type)
class TypeSpec extends Specification implements TestSchedulingFactory {

	Type type = validType()
	
	def setup() {
		mockForConstraintsTests Type
	}
	
	def 'a valid Type has no errors'() {
		when:
		type.validate()
		
		then:
		!type.hasErrors()
	}
	
	def 'toString is name'() {
		expect:
		type.toString() == 'nfl'
	}

	@Unroll
	def 'name with value #value validation error is #error'() {
		given:
		mockForConstraintsTests Type, [validType(), type]
		type.name = value
		type.validate()
		
		expect:
		type.errors.name == error
		
		where:
		value                || error
		' '                  || 'blank'
		'ab'                 || 'minSize'
		'ab2'                || 'matches'
		'ab '                || 'matches'
		'ab_'                || 'matches'
		'abc'                || null
		''.padRight(10, 'a') || null
		''.padRight(11, 'a') || 'maxSize'
		'nfl'                || 'unique'
	}

}
