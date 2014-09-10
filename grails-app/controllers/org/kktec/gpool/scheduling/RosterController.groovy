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
	
	def edit(Long id) {
		Roster roster = schedulingService.roster(id)
		render view: 'edit', model: [title: 'Edit Roster', roster: roster]
	}
	
	def update(Long id) {
		Roster roster = schedulingService.roster(id)
		if (roster) {
			roster.name = params.name
			if (!schedulingService.saveRoster(roster)) {
				render view: 'edit', model: [title: 'Edit Roster', roster: roster]
				return
			}
			flash.message = "Roster $roster.id has been updated"
		} else {
			flash.message = "Roster $id could not be found"
		}
		redirect action: 'rosters'
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
