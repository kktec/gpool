package org.kktec.gpool.user

import geb.Page

class ChangePasswordPage extends Page {

	static to = 'user/changePassword'
	
	static at = {
		title == 'Change Password'
	}
	
	static content = {
		newPassword { $('input', name: 'newPassword') }
		repeatPassword { $('input', name: 'repeatPassword') }
		updatePassword { $('input', type: 'submit') }
	}
}
