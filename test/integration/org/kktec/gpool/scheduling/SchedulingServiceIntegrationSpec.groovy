package org.kktec.gpool.scheduling

import spock.lang.Shared
import grails.test.spock.IntegrationSpec

class SchedulingServiceIntegrationSpec extends IntegrationSpec {

	@Shared SchedulingService schedulingService
	
	def 'can view a list of Types'() {
		when:
		List types = schedulingService.types()*.name
		
		then:
		types.size() == 2
		types.contains 'Football'
		types.contains 'Baseball'
	}
	
	def 'can fetch a Type'() {
		when:
		Type type = schedulingService.type 1
		
		then:
		type.name == 'Baseball'
	}
	
	def 'can view a list of Rosters'() {
		when:
		List rosters = schedulingService.rosters()*.name
		
		then:
		rosters.size() == 1
		rosters[0] == 'NFL'
	}
	
	def 'can save and delete a valid Type'() {
		given:
		Type soccer = new Type('Soccer')
		
		when:
		Type type = schedulingService.saveType(soccer)
		
		then:
		type.id
		Type.list().size == 3
		
		when:
		schedulingService.deleteType(type.id)
		
		then:
		Type.list().size == 2
	}


	def 'can save and delete a valid Roster'() {
		given:
		Type type = new Type('Soccer').save()
		Roster mls = new Roster(type: type, name: 'mls')
		
		when:
		Roster roster = schedulingService.saveRoster(mls)
		
		then:
		roster.id
		Roster.list().size == 2
		
		when:
		schedulingService.deleteRoster(roster.id)
		
		then:
		Roster.list().size == 1
	}

}
