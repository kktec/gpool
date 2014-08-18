package org.kktec.gpool.pool

import geb.Page

class HomePage extends Page {

	static url = 'pool/home'
	
	static at = {
		title == 'Home'
	}
}
