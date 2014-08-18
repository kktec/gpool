package org.kktec.gpool.pool

import grails.test.mixin.TestFor

import org.kktec.gpool.PoolController

import spock.lang.Specification

@TestFor(PoolController)
class PoolControllerSpec extends Specification {
	
	def 'a User can view the home page'() {
		when:
		controller.home()
		
		then:
		view == '/pool/home'
		model.title == 'Home'
	}
}
