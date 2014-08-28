package org.kktec.gpool.admin

import org.kktec.gpool.GPoolFunctionalSpec

class AdminFunctionalSpec extends GPoolFunctionalSpec {
	
	def 'a user with ROLE_USER can NOT view the Admin page'() {
		given:
		signInWithRoleUser()
		
		when:
		go 'admin'
		
		then:
		title == 'Access Denied'
	}
	
	def 'a user with ROLE_POOL can NOT view the Admin page'() {
		given:
		signInWithRolePool()
		
		when:
		go 'admin'
		
		then:
		title == 'Access Denied'
	}

	def 'a user with ROLE_ADMIN can view the Admin page and User list'() {
		given:
		signInWithRoleAdmin()
		
		when:
		go 'admin'
		
		then:
		at AdminPage
		users()
		addUser()
	}
	
	def 'a user with ROLE_ADMIN can add a new User'() {
		given:
		signInWithRoleAdmin()
		go 'admin'
		
		expect:
		at AdminPage
		
		when:
		addUser().click()
		
		then:
		at AddUserPage
	}
}
