package org.kktec.gpool.guest

import org.kktec.gpool.GPoolFunctionalSpec
import org.kktec.gpool.pool.HomePage

class AuthenticationFunctionalSpec extends GPoolFunctionalSpec {

	def 'a  guest can NOT Sign In with incorrect credentials'() {
		when:
		signIn 'dave', 'badPassword'

		then:
		$('#signInError').text() == "Sorry, we cannot find a user with that Username and Password"
	}
	
	def 'a guest can Sign In with correct credentials'() {
		when:
		signInWithRoleUser()
		
		then:
		at HomePage
	}

	def 'a signed in user can Sign Out'() {
		given:
		signInWithRoleUser()
		
		when:
		go 'signOut'
		
		then:
		title == 'Sign In'
	}
}
