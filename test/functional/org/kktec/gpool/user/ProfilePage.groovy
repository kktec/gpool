package org.kktec.gpool.user

import geb.Page

class ProfilePage extends Page {

	static to = 'user/profile'
	
	static at = {
		title == 'Profile'
	}
	
	static content = {
		changePassword { $('a', text: 'Change Password') }
		email { $('#email') }
		changeEmail { $('a', text: 'Change Email') }
	}
}
