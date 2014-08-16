package org.kktec.gpool.guest

import geb.spock.GebReportingSpec

class WelcomeFuntionalSpec extends GebReportingSpec {

	def setup() { to WelcomePage }
	
	def 'a guest can Register'() {
		expect:
		at WelcomePage
		register.click()
		at RegistrationPage
	}
}
