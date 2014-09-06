package org.kktec.gpool.scheduling

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Contestant)
class ContestantSpec extends Specification implements TestSchedulingFactory {
	
	Contestant contestant = validContestant(type: validType())

	def setup() {
		mockForConstraintsTests Contestant
	}
	
	def 'a valid Player has no errors'() {
		when:
		contestant.validate()
		
		then:
		!contestant.hasErrors()
	}
	
	def 'a Player has a fullName'() {
		expect:
		contestant.fullName == 'Green Bay Packers'
	}
	
	@Unroll
	def 'firstName with value #value validation error is #error'() {
		given:
		contestant.firstName = value
		contestant.validate()
		
		expect:
		contestant.errors.firstName == error
		
		where:
		value                || error
		' '                  || 'blank'
		'a2'                 || 'minSize'
		'a_2'                || 'matches'
		'aB2'                || null
		''.padRight(25, 'a') || null
		''.padRight(26, 'a') || 'maxSize'
	}

	@Unroll
	def 'lastName with value #value validation error is #error'() {
		given:
		contestant.lastName = value
		contestant.validate()
		
		expect:
		contestant.errors.lastName == error
		
		where:
		value                  || error
		' '                    || 'blank'
		'a2'                   || 'minSize'
		'a_2'                  || 'matches'
		'aB2'                  || null
		'25'.padRight(25, 'a') || null
		'26'.padRight(26, 'a') || 'maxSize'
	}

}
