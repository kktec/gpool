package org.kktec.gpool.user

import org.kktec.gpool.GPoolFunctionalSpec

class ProfileFunctionalSpec extends GPoolFunctionalSpec {

	def setup() { 
		signInWithRolePool()
		go 'user/profile'
	}
	
	def 'a user can change their profile'() {
		expect:
		at ProfilePage
		email()
		
		when:
		changeProfile().click()
		
		then:
		at ChangeProfilePage
	}

	def 'a user can change their password'() {
		expect:
		at ProfilePage
		
		when:
		changePassword().click()
		
		then:
		at ChangePasswordPage
	}
	
}
