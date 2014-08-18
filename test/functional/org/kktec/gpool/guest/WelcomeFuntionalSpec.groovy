package org.kktec.gpool.guest

import geb.spock.GebReportingSpec

import org.kktec.gpool.pool.HomePage

class WelcomeFuntionalSpec extends GebReportingSpec {

	def 'the default entry point is the Welcome page'() {
		when:
		go ''
		
		then:
		at WelcomePage
	}
	
	def 'a guest can Register'() {
		when:
		to WelcomePage
		
		then:
		at WelcomePage
		register.click()
		at RegistrationPage
	}
	
	def 'a guest can Sign In'() {
		when:
		to WelcomePage
		
		then:
		at WelcomePage
		signIn
	}
}
