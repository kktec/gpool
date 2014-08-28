package org.kktec.gpool

import geb.spock.GebReportingSpec

abstract class GPoolFunctionalSpec extends GebReportingSpec {
	
	protected final signInWithRoleUser() {
		signIn 'carol', 'mommom'
	}
	
	protected final signInWithRolePool() {
		signIn 'dave', 'evaddave'
	}
	
	protected final signInWithRoleAdmin() {
		signIn 'ken', 'nekken'
	}
	
	protected final signIn(String username, String password) {
		go 'guest/signIn'
		$('input[name=username]').value(username)
		$('input[name=password]').value(password)
		$('input[type=submit]').click()
	}
	
	protected final signOut() { go '/signOut' }
}
