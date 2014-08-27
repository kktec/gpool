package org.kktec.gpool.user

import geb.Page

class ProfilePage extends Page {

	static to = 'user/profile'
	
	static at = {
		title == 'Profile'
	}
	
	static content = {
		email { $('#email') }
		changePassword { $('a', text: 'Change Password') }
		changeProfile{ $('a', text: 'Change Profile') }
	}
}
