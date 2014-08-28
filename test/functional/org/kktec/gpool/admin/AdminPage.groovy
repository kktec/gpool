package org.kktec.gpool.admin

import geb.Page

class AdminPage extends Page {

	static url = 'admin'
	
	static at = {
		title == 'Admin'
	}
	
	static content = {
		users { $('#users') }
	}
}
