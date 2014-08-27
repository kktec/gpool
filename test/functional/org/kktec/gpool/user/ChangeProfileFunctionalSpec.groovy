package org.kktec.gpool.user

import org.kktec.gpool.GPoolFunctionalSpec

class ChangeProfileFunctionalSpec extends GPoolFunctionalSpec {

	def setup() {
		signInWithRolePool()
		go 'user/changeProfile'
	}
	
	def 'a user can change their profile'() {
		expect:
		at ChangeProfilePage
		email().value() == 'dave@kktec.org'
		
		when:
		email().value('davey@kktec.com')
		updateProfile().click()
		
		then:
		at ProfilePage
		email().value() == 'davey@kktec.com'
	}
}
