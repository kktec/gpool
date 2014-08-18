package org.kktec.gpool

import geb.spock.GebReportingSpec

abstract class GPoolFunctionalSpec extends GebReportingSpec {
	
	protected final signInWithRoleUser() {
		signIn 'carol', 'mom'
	}
	
	protected final signInWithRolePool() {
		signIn 'dave', 'evad'
	}
	
	protected final signInWithRoleAdmin() {
		signIn 'ken', 'nek'
	}
	
	protected final signIn(String username, String password) {
		go 'guest/signIn'
		$('input[name=username]').value(username)
		$('input[name=password]').value(password)
		$('input[type=submit]').click()
	}
}
