package org.kktec.gpool.admin

import geb.Page

class AddUserPage extends Page {

	static url = 'admin/addUser'
	
	static at = {
		title == 'Add User'
	}
	
	static content = {
		username { $('input', name: 'username') }
		email { $('input', name: 'email') }
		createUser { $('input', type: 'submit') }
	}
}
