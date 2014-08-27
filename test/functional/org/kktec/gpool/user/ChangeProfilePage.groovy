package org.kktec.gpool.user

import geb.Page

class ChangeProfilePage extends Page {

	static to = 'user/changeProfile'
	
	static at = {
		title == 'Change Profile'
	}
	
	static content = {
		email { $('input', name: 'email') }
		updateProfile { $('input', type: 'submit') }
	}
}
