package org.kktec.gpool.scheduling

import grails.plugin.springsecurity.annotation.Secured

import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_POOL'])
class RosterController {
	
	def schedulingService
	
	def rosters() {
		render view: 'rosters', model: [title: 'Rosters', rosters: schedulingService.rosters()]
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
