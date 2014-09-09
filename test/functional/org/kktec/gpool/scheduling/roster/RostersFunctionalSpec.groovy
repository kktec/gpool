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
		type().value 'Baseball'
		saveRoster().click()

		then:
		at RostersPage
	}
	
	static content = {
		name { $('input', name: 'name') }
		type { $('form').type }
		saveRoster { $('input', type: 'submit') }
		id { $('input', name: 'id') }
	}
}
