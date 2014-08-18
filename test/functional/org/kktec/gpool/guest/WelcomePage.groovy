package org.kktec.gpool.guest

import geb.Page

class WelcomePage extends Page {

	static url = 'guest/welcome'
	
	static at = { 
		title == 'Welcome'
		$('#heading').text() == 'Welcome'
	}
	
	static content = {
		register { $('a', text: 'Register') }
		signIn { $('a', text: 'Sign In') }
	}
}
