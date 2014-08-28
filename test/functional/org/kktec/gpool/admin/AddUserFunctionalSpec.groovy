package org.kktec.gpool.admin

import org.kktec.gpool.GPoolFunctionalSpec
import org.kktec.gpool.pool.HomePage

class AddUserFunctionalSpec extends GPoolFunctionalSpec {
	
	def setup() { signInWithRoleAdmin() }

	def 'an admin can add a new User'() {
		when:
		to AddUserPage
		
		then:
		at AddUserPage
		username().value('newby')
		email().value('newby@kktec.org')
		
		when:
		createUser().click()
		
		then:
		at AdminPage
		message() == 'Added a new User: newby'
		
		when:
		signOut()
		signIn 'newby', 'newuser'
		
		then:
		at HomePage
	}
}
