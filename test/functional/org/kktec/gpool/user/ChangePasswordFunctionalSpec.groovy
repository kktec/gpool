package org.kktec.gpool.user

import org.kktec.gpool.GPoolFunctionalSpec

class ChangePasswordFunctionalSpec extends GPoolFunctionalSpec {

	def setup() {
		signInWithRoleUser()
		go 'user/changePassword'
	}
	
	def 'a user can change their password'() {
		expect:
		at ChangePasswordPage
		
		when:
		newPassword.value('123456')
		repeatPassword.value('123456')
		updatePassword.click()
		
		then:
		at ProfilePage
	}
	

}
