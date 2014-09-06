package org.kktec.gpool.scheduling

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Roster)
class RosterSpec extends Specification implements TestSchedulingFactory {
	
	Roster roster = validRoster(type: validType())

	def setup() {
		mockForConstraintsTests Roster
	}
	
	def 'a valid Roster has no errors'() {
		when:
		roster.validate()
		
		then:
		!roster.hasErrors()
	}
	
	@Unroll
	def 'name with value #value validation error is #error'() {
		given:
		mockForConstraintsTests Roster, [validRoster(), roster]
		roster.name = value
		roster.validate()
		
		expect:
		roster.errors.name == error
		
		where:
		value                  || error
		' '                    || 'blank'
		'a2'                   || 'minSize'
		'a_2'                  || 'matches'
		'aB2'                  || null
		'25'.padRight(25, 'a') || null
		'26'.padRight(26, 'a') || 'maxSize'
		'a Roster'             || 'unique'
	}

}
