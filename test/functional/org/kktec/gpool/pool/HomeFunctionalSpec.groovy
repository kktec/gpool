package org.kktec.gpool.pool

import org.kktec.gpool.GPoolFunctionalSpec
import org.kktec.gpool.user.ProfilePage

class HomeFunctionalSpec extends GPoolFunctionalSpec {
	
	def setup() { signInWithRoleUser() }
	
	def 'a User can view the Home page'() {
		when:
		to HomePage
		
		then:
		at HomePage
	}

	def 'a User can view their Profile page'() {
		when:
		to HomePage
		profile().click()
		
		then:
		at ProfilePage
	}

}
