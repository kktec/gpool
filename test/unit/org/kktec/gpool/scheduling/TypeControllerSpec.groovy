package org.kktec.gpool.scheduling

import grails.test.mixin.TestFor

import org.springframework.dao.DataIntegrityViolationException

import spock.lang.Specification

@TestFor(TypeController)
class TypeControllerSpec extends Specification implements TestSchedulingFactory {
	
	SchedulingService schedulingService = Mock()
	
	List types = [validType()]
	
	def setup() {
		controller.schedulingService = schedulingService
	}

	def 'a pool user can view a list of Types'() {
		when:
		controller.types()
		
		then:
		1 * schedulingService.types() >> types
		0 * _
		view == '/type/types'
		model.title == 'Types'
		model.types == types
	}
	
	def 'a pool user can add a new Type'() {
		when:
		controller.addNew()
		
		then:
		0 * _
		view == '/type/addNew'
		model.title == 'Add New Type'
		model.type
	}
	
	def 'a pool user can save a new valid Type'() {
		given:
		Type type = new Type('someType')
		
		when:
		controller.saveNew(type)
		
		then:
		1 * schedulingService.saveType(type) >> type
		0 * _
		response.redirectedUrl == '/type/types'
	}

	def 'a pool user can NOT save a new invalid Type'() {
		given:
		Type type = new Type()
		
		when:
		controller.saveNew(type)
		
		then:
		1 * schedulingService.saveType(type) >> null
		0 * _
		view == '/type/addNew'
	}
	
	def 'a pool user can edit a Type'() {
		given:
		Long id = 1
		Type type = new Type('someType')
		
		when:
		controller.edit(id)
		
		then:
		1 * schedulingService.type(id) >> type
		0 * _
		view == '/type/edit'
		model.title == 'Edit Type'
		model.type == type
	}
	
	def 'a pool user can update a valid Type'() {
		given:
		Long id = 1
		Type type = validType()
		params.name = 'aType'
		
		when:
		controller.update(id)
		
		then:
		1 * schedulingService.type(id) >> type
		type.name == 'aType'
		1 * schedulingService.saveType(type) >> type
		0 * _
		flash.message == 'Type 1 has been updated'
		response.redirectedUrl == '/type/types'
	}
	
	def 'a pool user can NOT update an invalid Type'() {
		given:
		Long id = 1
		Type type = validType()
		params.name = ''
		
		when:
		controller.update(id)
		
		then:
		1 * schedulingService.type(id) >> type
		type.name == ''
		1 * schedulingService.saveType(type) >> null
		0 * _
		view == '/type/edit'
	}
	
	def 'a pool user can NOT update a Type that cannot be found'() {
		given:
		Long id = 1
		
		when:
		controller.update(id)
		
		then:
		1 * schedulingService.type(id) >> null
		0 * _
		flash.message == 'Type 1 could not be found'
		response.redirectedUrl == '/type/types'
	}
	
	def 'can delete a Type'() {
		given:
		def id = 3
		
		when:
		controller.delete(id)
		
		then:
		1 * schedulingService.deleteType(id)
		0 * _
		response.redirectedUrl == '/type/types'
		flash.message == 'Type 3 was deleted'
	}
	
	def 'can NOT delete a Type that is in use'() {
		given:
		def id = 3
		
		when:
		controller.delete(id)
		
		then:
		1 * schedulingService.deleteType(id) >> { throw new DataIntegrityViolationException('') }
		0 * _
		response.redirectedUrl == '/type/types'
		flash.message == 'Type 3 is in use and cannot be deleted'
	}
}
