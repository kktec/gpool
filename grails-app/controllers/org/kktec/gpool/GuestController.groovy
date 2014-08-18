package org.kktec.gpool

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class GuestController {

	def welcome() { 
		render view: 'welcome', model: [title: 'Welcome']
	}
		
	def register() {
		render view: 'register', model: [title: 'Register']
	}
	
	def signIn() {
		render view: 'signIn', model: [title: 'Sign In']
	}
}
