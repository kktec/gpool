package org.kktec.gpool.scheduling

import grails.plugin.springsecurity.annotation.Secured

import org.springframework.dao.DataIntegrityViolationException

@Secured(['ROLE_POOL'])
class TypeController {
	
	def schedulingService
	
	def types() {
		render view: 'types', model: [title: 'Types', types: schedulingService.types()]
	}
	
	def addNew(Type type) {
		render view: 'addNew', model: [title: 'Add New Type', type: type ?: new Type()]
	}
	
	def saveNew(Type type) {
		if (schedulingService.saveType(type)) {
			redirect action: 'types'
			return
		}
		
		addNew(type)
	}
	
	def edit(Long id) {
		Type type = schedulingService.type id
		render view: 'edit', model: [title: 'Edit Type', type: type]
	}
	
	def update(Long id) {
		Type type = schedulingService.type id
		if (type) {
			type.name = params.name
			if (!schedulingService.saveType(type)) {
				render view: 'edit', model: [title: 'Edit Type', type: type]
				return
			}
			flash.message = "Type $id has been updated"
		} else {
			flash.message = "Type $id could not be found"
		}
		redirect action: 'types'
	}
	
	def delete(Long id) {
		try {
			schedulingService.deleteType(id)
			flash.message = "Type ${id} was deleted"
		} catch (DataIntegrityViolationException x) {
			flash.message = "Type ${id} is in use and cannot be deleted"
		}
		redirect action: 'types'
	}

}
