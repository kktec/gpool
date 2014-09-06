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
	}
}
