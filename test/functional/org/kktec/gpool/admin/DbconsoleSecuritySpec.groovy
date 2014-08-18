package org.kktec.gpool.admin

import org.kktec.gpool.GPoolFunctionalSpec

class DbconsoleSecuritySpec extends GPoolFunctionalSpec {
	
	def 'a user with Role User can NOT access dbconsole'() {
		given:
		signInWithRoleUser()
		
		when:
		go 'dbconsole'
		
		then:
		title.contains('Access Denied')
	}
	
	def 'a user with Role Pool can NOT access dbconsole'() {
		given:
		signInWithRolePool()
		
		when:
		go 'dbconsole'
		
		then:
		title.contains('Access Denied')
	}

	def 'a user with Role Admin can access dbconsole'() {
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
