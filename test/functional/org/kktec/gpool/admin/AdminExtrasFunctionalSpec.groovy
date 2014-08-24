package org.kktec.gpool.admin

import org.kktec.gpool.GPoolFunctionalSpec
import org.kktec.gpool.pool.HomePage

class AdminExtrasFunctionalSpec extends GPoolFunctionalSpec {
	
	def 'user can NOT see admin extras'() {
		given:
		signInWithRoleUser()
		
		when:
		to HomePage
		
		then:
		info()
		!extras()
	}
	
	def 'pool can NOT see admin extras'() {
		given:
		signInWithRolePool()
		
		when:
		to HomePage
		
		then:
		info()
		!extras()
	}

	def 'admin can see admin extras'() {
		given:
		signInWithRoleAdmin()
		
		when:
		to HomePage
		
		then:
		info()
		extras()
	}
}
