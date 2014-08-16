package org.kktec.gpool.guest

import grails.test.mixin.TestFor

import org.kktec.gpool.GuestController

import spock.lang.Specification

@TestFor(GuestController)
class GuestControllerSpec extends Specification {

	def 'a guest can view the welcome page'() {
		when:
		controller.welcome()
		
		then:
		view == '/guest/welcome'
		model.title == 'Welcome'
	}
	
	def 'a guest can view the registration page'() {
		when:
		controller.register()
		
		then:
		view == '/guest/register'
		model.title == 'Register'
	}
}
