package org.kktec.gpool.pool

import org.kktec.gpool.GPoolFunctionalSpec

class HomeFunctionalSpec extends GPoolFunctionalSpec {
	
	def setup() {
		signInWithRoleUser()
	}
	
	def 'a User can view the Home page'() {
		when:
		to HomePage
		
		then:
		at HomePage
	}

}
