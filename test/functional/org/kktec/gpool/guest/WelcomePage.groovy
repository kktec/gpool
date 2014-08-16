package org.kktec.gpool.guest

import geb.Page

class WelcomePage extends Page {

	static url = '/gpool/guest/welcome'
	
	static at = { 
		title == 'Welcome'
		$('#heading').text() == 'Welcome'
	}
	
	static content = {
		register { $('a', text: 'Register') }
	}
}
