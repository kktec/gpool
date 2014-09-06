package org.kktec.gpool.scheduling

import org.kktec.gpool.GPoolFunctionalSpec
import org.kktec.gpool.pool.HomePage

class SchedulingFunctionalSpec extends GPoolFunctionalSpec {
	
	def 'a user with ROLE_USER can NOT view the Scheduling page'() {
		given:
		signInWithRoleUser()
		
		expect:
		at HomePage
		!scheduling()
		
		when:
		go 'scheduling'
		
		then:
		title == 'Access Denied'
	}
	
	def 'a user with ROLE_POOL can view the Scheduling page'() {
		given:
		signInWithRolePool()
		
		expect:
		at HomePage
		scheduling()
		
		when:
		go 'scheduling'
		
		then:
		at SchedulingPage
		types()
		rosters()
	}

	def 'a user with ROLE_POOL can view the Types page'() {
		given:
		signInWithRolePool()
		
		when:
		go 'scheduling'
		
		then:
		at SchedulingPage
		
		when:
		types().click()
		
		then:
		title == 'Types'
	}

	def 'a user with ROLE_POOL can view the Rosters page'() {
		given:
		signInWithRolePool()
		
		when:
		go 'scheduling'
		
		then:
		at SchedulingPage
		
		when:
		rosters().click()
		
		then:
		title == 'Rosters'
	}

}
