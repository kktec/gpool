package org.kktec.gpool.pool

import geb.Page

class HomePage extends Page {

	static url = 'pool/home'
	
	static at = {
		title == 'Home'
	}
	
	static content = {
		info { $('#info') }
		extras(required: false) { $('#extras') }
		profile { $('a', text: 'Your Profile') }
		scheduling(required: false)  { $('a', text: 'Scheduling') }
	}
}
