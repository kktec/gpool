package org.kktec.gpool.scheduling

import grails.plugin.springsecurity.annotation.Secured

import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_POOL'])
class RosterController {
	
	def schedulingService
	
	def rosters() {
		render view: 'rosters', model: [title: 'Rosters', rosters: schedulingService.rosters()]
	}
	
	def addNew(Roster roster) {
		Map model = [
			title: 'Add New Roster',
			roster: roster ?: new Roster(),
			types: schedulingService.types()
		]
		render view: 'addNew', model: model
	}
	
	def saveNew(Roster roster) {
		if (schedulingService.saveRoster(roster)) {
			flash.message = "Roster $roster.id has been added"
			redirect action: 'rosters'
			return
		}
		
		addNew(roster)
	}
	
	def delete(Long id) {
		try {
			schedulingService.deleteRoster(id)
			flash.message = "Roster ${id} was deleted"
		} catch (DataIntegrityViolationException x) {
			flash.message = "Roster ${id} is in use and cannot be deleted"
		}
		redirect action: 'rosters'
	}

}
