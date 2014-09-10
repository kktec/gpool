package org.kktec.gpool.scheduling

import grails.test.mixin.TestFor

import org.springframework.dao.DataIntegrityViolationException

import spock.lang.Specification

@TestFor(RosterController)
class RosterControllerSpec extends Specification implements TestSchedulingFactory {

	SchedulingService schedulingService = Mock()
	
	List rosters = [validRoster()]
	
	List types = [validType()]
	
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
	
	def 'a pool user can add a new Roster'() {
		when:
		controller.addNew()
		
		then:
		1 * schedulingService.types() >> types
		0 * _
		view == '/roster/addNew'
		model.title == 'Add New Roster'
		model.roster
		model.types == types
	}
	
	def 'a pool user can save a new valid Roster'() {
		given:
		Roster roster = rosters[0]
		roster.id = 1
		
		when:
		controller.saveNew(roster)
		
		then:
		1 * schedulingService.saveRoster(roster) >> roster
		0 * _
		flash.message == 'Roster 1 has been added'
		response.redirectedUrl == '/roster/rosters'
	}

	def 'a pool user can NOT save a new invalid Roster'() {
		given:
		Roster roster = new Roster()
		
		when:
		controller.saveNew(roster)
		
		then:
		1 * schedulingService.saveRoster(roster) >> null
		1 * schedulingService.types() >> types
		0 * _
		view == '/roster/addNew'
	}
	
	def 'a pool user can edit a Roster'() {
		given:
		Long id = 1
		Roster roster = new Roster(name: 'someRoster', type: types[0])
		
		when:
		controller.edit(id)
		
		then:
		1 * schedulingService.roster(id) >> roster
		0 * _
		view == '/roster/edit'
		model.title == 'Edit Roster'
		model.roster == roster
	}
	
	def 'a pool user can update a valid Roster'() {
		given:
		Long id = 1
		Roster roster = validRoster()
		roster.id = id
		params.name = 'aRoster'
		
		when:
		controller.update(id)
		
		then:
		1 * schedulingService.roster(id) >> roster
		roster.name == 'aRoster'
		1 * schedulingService.saveRoster(roster) >> roster
		0 * _
		flash.message == 'Roster 1 has been updated'
		response.redirectedUrl == '/roster/rosters'
	}
	
	def 'a pool user can NOT update an invalid Roster'() {
		given:
		Long id = 1
		Roster roster = validRoster()
		params.name = ''
		
		when:
		controller.update(id)
		
		then:
		1 * schedulingService.roster(id) >> roster
		roster.name == ''
		1 * schedulingService.saveRoster(roster) >> null
		0 * _
		view == '/roster/edit'
	}
	
	def 'a pool user can NOT update a Roster that cannot be found'() {
		given:
		Long id = 1
		
		when:
		controller.update(id)
		
		then:
		1 * schedulingService.roster(id) >> null
		0 * _
		flash.message == 'Roster 1 could not be found'
		response.redirectedUrl == '/roster/rosters'
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
