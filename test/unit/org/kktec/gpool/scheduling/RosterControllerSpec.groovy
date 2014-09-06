package org.kktec.gpool.scheduling

import grails.test.mixin.TestFor

import org.springframework.dao.DataIntegrityViolationException

import spock.lang.Specification

@TestFor(RosterController)
class RosterControllerSpec extends Specification implements TestSchedulingFactory {

	SchedulingService schedulingService = Mock()
	
	List rosters = [validRoster()]
	
	def setup() {
		controller.schedulingService = schedulingService
	}

	def 'a pool user can view a list of Rosters'() {
		when:
		controller.rosters()
		
		then:
		1 * schedulingService.rosters() >> rosters
		0 * _
		view == '/roster/rosters'
		model.title == 'Rosters'
		model.rosters == rosters
	}
	
	def 'can delete a Roster'() {
		given:
		def id = 3
		
		when:
		controller.delete(id)
		
		then:
		1 * schedulingService.deleteRoster(id)
		0 * _
		response.redirectedUrl == '/roster/rosters'
		flash.message == 'Roster 3 was deleted'
	}
	
	def 'can NOT delete a Roster that is in use'() {
		given:
		def id = 3
		
		when:
		controller.delete(id)
		
		then:
		1 * schedulingService.deleteRoster(id) >> { throw new DataIntegrityViolationException('') }
		0 * _
		response.redirectedUrl == '/roster/rosters'
		flash.message == 'Roster 3 is in use and cannot be deleted'
	}

}
