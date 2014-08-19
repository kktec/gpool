package org.kktec.security

import grails.test.spock.IntegrationSpec

class UseIntegrationSpec extends IntegrationSpec {

	def 'a user should have roles'() {
		given:
		User ken = User.findByUsername 'ken'
		
		when:
		Set authorities = ken.authorities*.authority
		
		then:
		authorities.size() == 3
		authorities.contains 'ROLE_USER'
		authorities.contains 'ROLE_POOL'
		authorities.contains 'ROLE_ADMIN'
	}
}
