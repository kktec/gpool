package org.kktec.gpool.guest

import geb.Page

class RegistrationPage extends Page {

	static url = '/gpool/guest/register'
	
	static at = { title == 'Register' }
}
