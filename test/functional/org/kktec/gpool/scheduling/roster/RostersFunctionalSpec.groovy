package org.kktec.gpool.scheduling.roster

import org.kktec.gpool.GPoolFunctionalSpec

class RostersFunctionalSpec extends GPoolFunctionalSpec {

	def 'a pool user can see a list of Rosters'() {
		given:
		signInWithRolePool()
		
		when:
		to RostersPage
		
		then:
		at RostersPage
		rosters()
		addNew()
	}
	
	def 'a pool user can add a new Roster'() {
		given:
		signInWithRolePool()
		
		when:
		go 'roster/addNew'
		
		then:
		title == 'Add New Roster'
		
		when:
		name().value('MLB')
		$('form').type = 'Baseball'
		saveRoster().click()

		then:
		at RostersPage
	}
	
	def 'a pool user can edit a Roster'() {
		given:
		signInWithRolePool()
		
		when:
		go 'roster/edit/1'
		
		then:
		title == 'Edit Roster'
		id().value() == '1'
		
		when:
		name().value('ACME')
		saveRoster().click()

		then:
		at RostersPage
	}
	
	static content = {
		name { $('input', name: 'name') }
		saveRoster { $('input', type: 'submit') }
		id { $('input', name: 'id') }
	}
}
