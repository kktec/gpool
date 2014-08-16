package org.kktec.gpool

class GuestController {

	def welcome() { 
		render view: 'welcome', model: [title: 'Welcome']
	}
		
	def register() {
		render view: 'register', model: [title: 'Register']
	}
}
