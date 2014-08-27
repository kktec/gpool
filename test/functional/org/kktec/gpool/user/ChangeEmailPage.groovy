package org.kktec.gpool.user

import geb.Page

class ChangeEmailPage extends Page {

	static to = 'user/changeEmail'
	
	static at = {
		title == 'Change Email'
	}
}
