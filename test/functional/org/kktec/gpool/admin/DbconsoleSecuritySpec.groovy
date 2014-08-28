package org.kktec.gpool.admin

import org.kktec.gpool.GPoolFunctionalSpec

class DbconsoleSecuritySpec extends GPoolFunctionalSpec {
	
	def 'a user with ROLE_USER can NOT access dbconsole'() {
		given:
		signInWithRoleUser()
		
		when:
		go 'dbconsole'
		
		then:
		title == 'Access Denied'
	}
	
	def 'a user with ROLE_POOL can NOT access dbconsole'() {
		given:
		signInWithRolePool()
		
		when:
		go 'dbconsole'
		
		then:
		title == 'Access Denied'
	}

	def 'a user with ROLE_ADMIN can access dbconsole'() {
		given:
		signInWithRoleAdmin()
		
		when:
		go 'dbconsole'
		
		then:
		// FIXME: needs improvement
//		title == 'dbconsole'
		!title.contains('Access Denied')
	}
}
